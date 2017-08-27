var app = angular.module('myApp', []);

		app.controller('MyController',function($scope, $http) {
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
		app.controller('enableDisable',function($scope){
			
		}
		);
		
