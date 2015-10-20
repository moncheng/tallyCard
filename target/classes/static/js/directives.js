tallyApp.directive('tallyCardModel', function() {
	return {
		scope: {
			card: '=ngModel'
		},
		controller: function($scope, $element) {
	        $scope.countUp = function() {
	        	$scope.card.count++
	        	//TODO Add call to Service to Push Update
	        } 
	        $scope.countDown = function() {
	        	$scope.card.count--
	        	//TODO Add call to Service to Push Update
	        }  
		},
		templateUrl: '/html/Card.html'
	};
});