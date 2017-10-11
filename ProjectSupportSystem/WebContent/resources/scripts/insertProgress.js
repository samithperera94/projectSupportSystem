var app = angular.module('myApp', []);
	app.controller('progressController', function($scope, $http) {
	
		$scope.insertProgressData = function() {
			console.log($scope.progress);
			$http({
				method : 'POST',
				url : 'http://localhost:8080/ProjectSupportSystem/InsertProgressReportInfo',
				contentType: 'application/json',
				data : JSON.stringify($scope.progress)
			}).then(function successCallback(data) {
				console.log(data);
			},function errorCallback (data) {
				console.log(data);
			});
			
		
		};
});
	
	app.controller('formController', function($scope, $http) {
		
		$scope.insertFormSubData = function() {
			console.log($scope.form);
			$http({
				method : 'POST',
				url : 'http://localhost:8080/ProjectSupportSystem//InsertFormsubInfo',
				contentType: 'application/json',
				data : JSON.stringify($scope.form)
			}).then(function successCallback(data) {
				console.log(data);
			},function errorCallback (data) {
				console.log(data);
			});
			
		
		};
});
	

	
	
	app.controller('reportListController', function($scope, $http) {
		$scope.myArray = [];
		$http({
			method : 'GET',
			url : 'http://localhost:8080/ProjectSupportSystem/DoViewPReportDetailsList'
		}).then(function successCallback(response) {
			$scope.myArray = response.data;
			console.log('success');
		}, function errorCallback(response) {
			console.log('error');
		});

	});
	
	
	app.controller('formSubListController', function($scope, $http) {
		$scope.myArray = [];
		$http({
			method : 'GET',
			url : 'http://localhost:8080/ProjectSupportSystem/DoViewFormDetailList'
		}).then(function successCallback(response) {
			$scope.myArray2 = response.data;
			console.log('success');
		}, function errorCallback(response) {
			console.log('error');
		});

	});
	
	