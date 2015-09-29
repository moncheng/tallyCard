
var tallyApp= angular.module('tallyApp',[]);

var templates =				[
            				 
            				 {'name':'greenCard',url:'../html/CardGreen.html'},
            				 {'name':'lightgreenCard',url:'../html/CardLightGreen.html'},
            				 {'name':'medgreenCard',url:'../html/CardMedGreen.html'}
            				 ];

tallyApp.controller('testController',function($scope)
		{
			$scope.templates=;
	
		});







function createRandomArray(num)
{
	//create a array with size of num or a loop with count of num
	//set var random range to templates's size
	// in loop, new array. add old array[random(range)].
 //return new array
}


//another solutino is, to have a basic Card template, with varies of color them in string or array
//when assign value to the card from db, assign the color theme too.