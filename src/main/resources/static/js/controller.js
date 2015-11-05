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
	$scope.orderBy = function(columnOn, rev, id) {
		if ($scope.column === columnOn && $scope.reverse === rev) {
			$scope.column = "dateCreate";//need a default sortting(most recent updated or created)
			$scope.reverse = "";
		} else
			{
			$scope.column = columnOn;
			$scope.reverse = rev;
			}

		if ($("#" + id).hasClass('btn-sort-on') === true)
			$("#" + id).removeClass('btn-sort-on');
		else
			$("#" + id).addClass('btn-sort-on');

	}

});
