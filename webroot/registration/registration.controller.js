angular.module('app').controller('RegistrationController', RegistrationController);

RegistrationController.$inject = ['AuthenticationService', '$location', '$rootScope', 'FlashService'];
function RegistrationController(AuthenticationService, $location, $rootScope, FlashService) {
	var vm = this;

	vm.register = register;
	
	(function() {
		AuthenticationService.GetManagers(function(response){
			vm.managerList = response;
			console.log(response);
			console.log(vm.managerList);
		});
	})();
	
	
	function register() {
		vm.dataLoading = true;
		
		console.log(vm.user);
		console.log(vm.manager);
		console.log(vm.user.manager.emp_id);
		
		AuthenticationService.Registration(vm.user,function(response){
			if (response.success) {
				FlashService.Success('Registration successful', true);
				$location.path('/login');
			} else {
				FlashService.Error(response.message);
				vm.dataLoading = false;
			}	
		});
	}

	function logout() 
	{
		console.log("Logout");
		AuthenticationService.ClearCredentials();
		$location.path('/login');
		FlashService.Success("Successfully Logged Out", true);
	}

	function back()
	{
		$location.path('/login');
		// window.history.back();
	}

}