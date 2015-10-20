
var tallyApp= angular.module('tallyApp',[]);

tallyApp.controller('testController', function($scope) {
	$scope.tallyCards=[{'name':'C','count':2},
	                   {'name':'Java','count':4}];
});


