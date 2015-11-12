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
				displayMsg("ok",$scope.tallyCard.name+"'s count successfully incremented by one.");
			}
			$scope.countDown = function() {
				var count=--$scope.tallyCard.count
				$http.get('http://localhost:8080/updateCount/'+$scope.tallyCard.name+'/'
						+count)
				displayMsg("ok",$scope.tallyCard.name+"'s count successfully decremented by one.");

				// TODO Add call to Service to Push Update
			}
			$scope.delete = function() {
				var name=$scope.tallyCard.name
				$element.empty()
				$http.delete('http://localhost:8080/removeCard/'+name)
				displayMsg("ok",$scope.tallyCard.name+" successfully deleted!");

			}

		},
		templateUrl : '/html/Card.html'
	};
});
