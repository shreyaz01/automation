angular.module('app').controller('UserHomeController', UserHomeController);

UserHomeController.$inject = ['$location', 'AuthenticationService', '$rootScope', 'FlashService', '$scope', '$timeout'];

function UserHomeController($location, AuthenticationService, $rootScope, FlashService, $scope, $timeout) 
{
	var vm = this;
	//functions
	vm.logout = logout;
	vm.defectprovisioning = defectprovisioning;
	vm.envprovisioning = envprovisioning;
	
	// store current user's name
	vm.user = $rootScope.globals.currentUser;
		
	function logout() 
	{
		console.log("Logout");
		AuthenticationService.ClearCredentials();
		$location.path('/login');
		FlashService.Success("Successfully Logged Out", true);
	}
	
	function back()
	{
		window.history.back();
	}
	
	function defectprovisioning()
	{
		$location.path('/userdefect');
	}
	
	function envprovisioning()
	{
		$location.path('/userenv');
	}
	
	
}
