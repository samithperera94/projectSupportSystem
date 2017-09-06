var app = angular.module('myApp', []);

app.controller('MyController', function($scope, $http) {
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem/DoViewDissertation'
	}).then(function successCallback(response) {
		$scope.dissertation = response.data;
		console.log('sucess');
	}, function errorCallback(response) {
		console.log('error');
	});

});
