var app = angular.module('myApp', []);

app.controller('MyController', function($scope, $http) {
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem/DoViewClient'
	}).then(function successCallback(response) {
		$scope.client = response.data;
		console.log('sucess');
	}, function errorCallback(response) {
		console.log('error');
	});

});
