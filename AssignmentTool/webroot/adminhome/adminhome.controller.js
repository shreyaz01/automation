angular.module('app').controller('AdminHomeController', AdminHomeController);

AdminHomeController.$inject = ['$location', 'AuthenticationService', '$rootScope', 'FlashService', '$scope', '$timeout'];

function AdminHomeController($location, AuthenticationService, $rootScope, FlashService, $scope, $timeout) 
{
	var vm = this;
	//functions
	vm.logout = logout;
	vm.defectprovisioning = defectprovisioning;
	vm.peopleprovisioning = peopleprovisioning;
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
		$location.path('/admindefect');
	}
	
	function peopleprovisioning()
	{
		$location.path('/people');
	}
	
	function envprovisioning()
	{
		$location.path('/adminenv');
	}
	
}
