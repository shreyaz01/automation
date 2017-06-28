angular.module('app').controller('AdminDefectController', AdminDefectController);

AdminDefectController.$inject = ['$location', 'AuthenticationService', '$rootScope', 'FlashService', '$scope', '$timeout', 'ngTableParams'];

function AdminDefectController($location, AuthenticationService, $rootScope, FlashService, $scope, $timeout, ngTableParams) 
{
	var vm = this;
	//functions
	vm.logout = logout;
	// store current user's name
	vm.user = $rootScope.globals.currentUser;
	vm.editRow = editRow;
	vm.technologiesArray = [];	
	
	// will call fetch all defects from DB on page load
	(function() {
		AuthenticationService.FetchAllDefects(function(response){
			vm.defectList = response;
			console.log("hi",response);
			vm.technologiesArray.push(vm.defectList);
            console.log("vm.technologies",vm.technologies);
		

		 vm.usersTable_technologies = new ngTableParams({
            page: 1,
            count: 2
        }, {
           // total: vm.defectList.length, 
            getData: function ($defer, params) {
            
                vm.data_technologies = params.sorting() ? $filter('orderBy')(vm.technologiesArray[0], params.orderBy()) : vm.technologiesArray[0];
                vm.data_technologies = params.filter() ? $filter('filter')(vm.data_technologies, params.filter()) : vm.data_technologies;
               vm.data_technologies = vm.data_technologies.slice((params.page() - 1) * params.count(), params.page() * params.count());
               $defer.resolve(vm.data_technologies)
            }
        });
        vm.usersTable_technologies.reload();

        });
	})();
	
	function logout() 
	{
		console.log("Logout");
		AuthenticationService.ClearCredentials();
		$location.path('/login');
		FlashService.Success("Successfully Logged Out", true);
	}
	
	function editRow()
	{

		console.log("edit");
	}

	function back()
	{
		window.history.back();
	}
	
}
