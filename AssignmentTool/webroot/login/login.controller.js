angular.module('app').controller('LoginController', LoginController);

LoginController.$inject = ['$location', '$scope' ,'$rootScope', 'AuthenticationService', 'FlashService'];
function LoginController($location,$scope,$rootScope, AuthenticationService, FlashService) {
	var vm = this;

	vm.login = login;
	vm.user = $rootScope.globals.currentUser;
	
	(function initController() {
		// reset login status
		AuthenticationService.ClearCredentials();
	})();

	//calls login function which is written in authentication service
	function login() {
		vm.dataLoading = true;
		$rootScope.searchValue = "";
		
		if (vm.username == vm.password) 
			{
				console.log("Login Successful");
				//FlashService.Success(response.message, true);
				AuthenticationService.SetCredentials(vm.username, vm.password);
				if(vm.username == 'admin')
				{
					$location.path('/adminhome');
				}
				else
				{
					$location.path('/userhome');
				}
			}
			else
			{
				console.log("Login Failure");
				FlashService.Error("Incorrect username / password");
				vm.dataLoading = false;
			}
		
//		AuthenticationService.Login(vm.username, vm.password, function (response) {
//			if (response.success) 
//			{
//				console.log("Login Successful");
//				//FlashService.Success(response.message, true);
//				AuthenticationService.SetCredentials(vm.username, vm.password);
//				AuthenticationService.Login(vm.username, function (response) {
//					//redirect admins and users to different screens
//				}
//				$location.path('/homescreen');
//			}
//			else
//			{
//				console.log("Login Failure");
//				FlashService.Error("Incorrect username / password");
//				vm.dataLoading = false;
//			}
//		});
	};
}