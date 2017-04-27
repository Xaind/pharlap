angular.module('pharlap', []).controller('home', function($scope, $http) {
	$http.get('resource/').then(function(response) {	
		$scope.greeting = response.data;
	})
	
	$scope.go = function() {
		alert('clicked!!!');
	}
	
});
