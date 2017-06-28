angular
.module('app')
.factory('UserService', UserService);

UserService.$inject = ['$http'];
function UserService($http) {
	var service = {};

	return service;

	// private functions

	function handleSuccess(res) 
	{
		return res.data;
	}

	function handleError(error) 
	{
		return function () 
		{
			return { success: false, message: error };
		};
	}
}
