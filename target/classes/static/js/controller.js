
var tallyApp= angular.module('tallyApp',[]);

tallyApp.controller('CardController', function($scope, $http) {
	
	$http.get('http://localhost:8080/getAllCards').then(function(resp) {
		$scope.tallyCards = resp.data;
	  })
});




//[{'name':'C','count':2,'id':1},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2},
// {'name':'Java','count':4,'id':2}]