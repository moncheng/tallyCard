var tallyApp = angular.module('tallyApp', []);

tallyApp.controller('CardController', function($scope, $element, $http) {

	$http.get('http://localhost:8080/getAllCards').then(function(resp) {
		$scope.tallyCards = resp.data;
	})
	$scope.addCard = function() {
		$http.post('http://localhost:8080/newCard/' + $scope.newName).
			success(function(data, status, headers, config) {
				return $scope.tallyCards.push(data);
			});
	
		alert("card added")
		$scope.newName="";

	}

});
