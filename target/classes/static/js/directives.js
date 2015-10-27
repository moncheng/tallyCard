tallyApp.directive('tallyCardModel', function() {
	return {
		scope : {
			tallyCard : '=ngModel'
		},
		controller : function($scope, $element,$http) {
			$scope.countUp = function() {
				var count=++$scope.tallyCard.count
				// TODO Add call to Service to Push Update
				$http.get('http://localhost:8080/updateCount/'+$scope.tallyCard.name+'/'
						+count)
			}
			$scope.countDown = function() {
				var count=--$scope.tallyCard.count
				$http.get('http://localhost:8080/updateCount/'+$scope.tallyCard.name+'/'
						+count)
				// TODO Add call to Service to Push Update
			}
			$scope.delete = function() {
				var name=$scope.tallyCard.name
				$element.empty()
				$http.delete('http://localhost:8080/removeCard/'+name)
			}

		},
		templateUrl : '/html/Card.html'
	};
});
