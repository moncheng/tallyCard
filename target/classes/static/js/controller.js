
var tallyApp= angular.module('tallyApp',[]);

tallyApp.controller('CardController', function($scope, $http) {
	
	$http.get('http://localhost:8080/getAllCards').then(function(resp) {
		$scope.tallyCards = resp.data;
	  })
});

