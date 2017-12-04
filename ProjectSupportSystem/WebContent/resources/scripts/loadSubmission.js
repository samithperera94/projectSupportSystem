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

/*app.controller('ProgressReportListController',function($scope,$http){
	$scope.loadProgressReportList = function() {
	$scope.reportList = [];
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem/DoViewProgressReportList'
	}).then(function successCallback(response) {
		$scope.reportList = response.data;
		console.log('success');
	}, function errorCallback(response) {
		console.log('error');
	});
	}
});*/

app.controller('progressReportMarkController', function($scope, $http) {
	$scope.insertProgressReportMarks = function() {
	console.log($scope.prMark);
	$http({
		method : 'POST',
		url : 'http://localhost:8080/ProjectSupportSystem/InsertProgressReportMark',
		contentType: 'application/json',
		data : JSON.stringify($scope.prMark)
	}).then(function successCallback(data) {
		$scope.prMark.mark = null;
		$scope.displayDataPR();
		$scope.loadProgressReportList();
		console.log(data);
	},function errorCallback(data) {
		console.log(data);
	});
}

$scope.displayDataPR = function() {
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem/DoViewProgressReportMarks'
	}).then(function successCallback(response) {
		$scope.marks = response.data;
		console.log('sucess');
	}, function errorCallback(response) {
		console.log('error');
	});
}

$scope.loadProgressReportList = function() {
	$scope.reportList = [];
	$http({
		method : 'GET',
		url : 'http://localhost:8080/ProjectSupportSystem/DoViewProgressReportList'
	}).then(function successCallback(response) {
		$scope.reportList = response.data;
		console.log('success');
	}, function errorCallback(response) {
		console.log('error');
	});
}

});


