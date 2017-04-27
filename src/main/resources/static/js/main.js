angular.module('pharlap', [])
.controller('mainCtrl', function($scope, $http, $filter) {
	var self = this;

	// Initialize the date to the next Saturday
	$scope.raceDate = $filter('date')(new Date(), 'dd/MM/yyyy');

	self.retrieveData = function() {
		var raceDay = {date: $scope.raceDate};
		$http.post("execute/", angular.toJson(raceDay));
	}

});
