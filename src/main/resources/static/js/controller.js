var tallyApp = angular.module('tallyApp', []);
var minCount = 0;
var maxCount = Number.MAX_VALUE;

tallyApp.controller('CardController', function($scope, $element, $http) {

	$http.get('http://localhost:8080/getAllCards').then(function(resp) {
		$scope.tallyCards = resp.data;
		$scope.created = 'dateCreate';
		$scope.reverse = true;
	})

	$scope.addCard = function() {
		$http.post('http://localhost:8080/newCard/' + $scope.newName).success(
				function(data, status, headers, config) {
					displayMsg("ok","Card: \""+$scope.newName+"\" added.");
					$scope.newName = "";
					return $scope.tallyCards.push(data);
				}).error(function(){
					displayMsg("error","Name \""+$scope.newName+"\" already in used! please re-enter a new name.");
					$scope.newName = "";
					});
	}
	$scope.search = function() {
		$scope.searchText = $("#searchName").val();
	}
	$scope.clearSearch = function() {
		$scope.searchText = "";
		$("#searchName").val("");

	}
	$scope.submitCountRange = function() {

		if ($("#minCount").val() === "")
			minCount = 0;
		else
			minCount = parseInt($("#minCount").val());
		if ($("#maxCount").val() == "")
			maxCount = Number.MAX_VALUE;
		else
			maxCount = parseInt($("#maxCount").val());
	}
	$scope.clearCountFliter = function() {
		minCount = 0;
		maxCount = Number.MAX_VALUE;
		$("#minCount").val("");
		$("#maxCount").val("");
	}

	$scope.filterCount = function(tallyCard) {
		return (tallyCard.count >= minCount && tallyCard.count <= maxCount);
	}
	$scope.orderBy = function(columnOn, sortBtnId, groupId) {
		if (columnOn === "created") {
			if ($('#by-created-arrow').hasClass('glyphicon-chevron-down')) {
				$('#by-created-arrow').removeClass('glyphicon-chevron-down');
				$('#by-created-arrow').addClass('glyphicon-chevron-up');
				$scope.reverse = false;
			} else {
				$('#by-created-arrow').removeClass('glyphicon-chevron-up');
				$('#by-created-arrow').addClass('glyphicon-chevron-down');
				$scope.reverse = true;
			}
		} else {
			if ($scope.primary === '' || $scope.primary == null) {
				$scope.primary = columnOn;
				switchSort(sortBtnId, groupId);
			} else {
				// check if the column contain group id without s
				if (($scope.primary.indexOf(groupId.substring(0,
						groupId.length - 1))) > -1) {
					if ($scope.primary === columnOn) {
						$scope.primary = "";
						if ($scope.secondary != '') {
							$scope.primary = $scope.secondary;
							$scope.secondary = '';
						}
					} else {
						$scope.primary = columnOn;
					}
					switchSort(sortBtnId, groupId);
				} else {
					if ($scope.secondary === columnOn) {
						$scope.secondary = "";

					} else {
						$scope.secondary = columnOn;
					}
					switchSort(sortBtnId, groupId);
				}
			}
		}
		// check if other sorts btn other than created are on, if so off create,
		// otherwise create on
		var isCountsOn = $("#counts").children().hasClass('btn-sort-on');
		var isNamesOn = $("#names").children().hasClass('btn-sort-on');
		if (isCountsOn === true || isNamesOn === true) {
			$("#sort-by-created").removeClass('btn-sort-on');
		} else {
			$("#sort-by-created").addClass('btn-sort-on');
		}
	}

});


function displayMsg(status,text)
{
	$msgBox=$("#top-msg-box");
	$msgIcon=$("#top-msg-icon");
	$msg=$("#top-msg");
	$msgBox.removeClass("error");
	$msgBox.removeClass("success");
	$msgIcon.removeClass("glyphicon-remove");
	$msgIcon.removeClass("glyphicon-ok");
	if(status==='ok'){
			$msgBox.addClass("success");
			$msgIcon.addClass("glyphicon-ok");
		}
	else{
			$msgBox.addClass("error");
			$msgIcon.addClass("glyphicon-remove");
		}
	$msg.text(text);
	$msgBox.fadeIn('fast').delay(3000).fadeOut('slow');
}

function switchSort(id, groupId) {

	if ($("#" + id).hasClass('btn-sort-on') === true)
		$("#" + id).removeClass('btn-sort-on');
	else {
		$("#" + groupId).children().removeClass('btn-sort-on');
		$("#" + id).addClass('btn-sort-on');
		$("#" + id).addClass('btn-sort-on');
	}

}
