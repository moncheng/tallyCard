var tallyApp = angular.module('tallyApp', []);

tallyApp.controller('CardController', function($scope, $element, $http) {

	$http.get('http://localhost:8080/getAllCards').then(function(resp) {
		$scope.tallyCards = resp.data;
	})
	$scope.addCard = function() {
		$http.post('http://localhost:8080/newCard/' + $scope.newName).success(
				function(data, status, headers, config) {
					return $scope.tallyCards.unshift(data);
				});

		alert("card added")
		$scope.newName = "";

	}

	$scope.orderBy = function(columnOn, sortBtnId, groupId) {

		if ($scope.primary === '' || $scope.primary ==null || $scope.primary === 'dateCreate') {
			$scope.primary = columnOn;
			switchSort(sortBtnId, groupId);
		} else {
			if ( ($scope.primary.indexOf(groupId.substring(0,groupId.length-1))) >-1) {
				if ($scope.primary === columnOn) {
					$scope.primary = "dateCreate";
				} else {
					$scope.primary = columnOn;
				}
				switchSort(sortBtnId, groupId);

			} else {
				if ($scope.secondary === columnOn) {
					$scope.secondary = "dateCreate";
				} else {
					$scope.secondary = columnOn;
				}
				switchSort(sortBtnId, groupId);
			}
		}

	}

});

function switchSort(id, groupId) {

	if ($("#" + id).hasClass('btn-sort-on') === true)
		$("#" + id).removeClass('btn-sort-on');
	else {
		$("#" + groupId).children().removeClass('btn-sort-on');
		$("#" + id).addClass('btn-sort-on');
		$("#" + id).addClass('btn-sort-on');
	}

}
