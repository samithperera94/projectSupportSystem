var app = angular.module('myApp', []);

app.controller('SupController', function($scope, $http) {
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem/DoViewSupervisor'
	}).then(function successCallback(response) {
		$scope.supervisor = response.data;
		console.log('sucess');
	}, function errorCallback(response) {
		console.log('error');
	});

});

app.controller('ProposalController', function($scope, $http) {
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem/DoViewProjectProposal'
	}).then(function successCallback(response) {
		$scope.proposal = response.data;
		
		console.log('sucess');
	}, function errorCallback(response) {
		console.log('error');
	});

});

app.controller('ClientController', function($scope, $http) {
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

app.controller('DissertationController', function($scope, $http) {
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

app.controller('InterimController', function($scope, $http) {
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem//DoViewInterimReport'
	}).then(function successCallback(response) {
		$scope.interim = response.data;
		console.log('success');
	}, function errorCallback(response) {
		console.log('error');
	});

});

app.controller('ProgressController', function($scope, $http) {
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem/DoViewProgressReport'
	}).then(function successCallback(response) {
		$scope.progressreport = response.data;
		console.log('sucess');
	}, function errorCallback(response) {
		console.log('error');
	});

});

app.controller('PlanController', function($scope, $http) {
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem/DoViewProjectPlan'
	}).then(function successCallback(response) {
		$scope.plan = response.data;
		console.log('sucess');
	}, function errorCallback(response) {
		console.log('error');
	});

});

