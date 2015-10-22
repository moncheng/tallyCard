tallyApp.directive('tallyCardModel', function() {
	return {
		scope : {
			tallyCard : '=ngModel'
		},
		controller : function($scope, $element) {
			$scope.countUp = function() {
				$scope.tallyCard.count++
				// TODO Add call to Service to Push Update
			}
			$scope.countDown = function() {
				$scope.tallyCard.count--
				// TODO Add call to Service to Push Update
			}
		},
		templateUrl : '/html/Card.html'
	};
});