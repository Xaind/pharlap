angular.module('pharlap', [])
.controller('mainCtrl', function($scope, $http, $filter) {
	var self = this;

	// Initialize the date to the next Saturday
	$scope.raceDate = $filter("date")(new Date(), "dd/MM/yyyy");

	self.xretrieveData = function() {
		$http.post("getUpcomingRaceDays/").then(function(response) {			
			$scope.raceDays = response.data;
		}, function(error) {
			alert(error);
		});
	}
	
	self.retrieveData = function() {
		$http.post("raceDay/", 'date=01/01/2017', {headers: {'Content-Type': 'application/x-www-form-urlencoded'}}).then(function(response) {				
			$scope.raceDays = response.data;
		}, function(error) {
			//alert(error);
		});
	}
});
