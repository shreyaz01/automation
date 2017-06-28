angular.module('app').controller('UserEnvController', UserEnvController);

UserEnvController.$inject = ['$location', 'AuthenticationService', '$rootScope', 'FlashService', '$scope', '$timeout'];

function UserEnvController($location, AuthenticationService, $rootScope, FlashService, $scope, $timeout) 
{
	var vm = this;
	//functions
	vm.logout = logout;
	
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
	
	
}
