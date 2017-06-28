 angular.module('app').factory('AuthenticationService', AuthenticationService);

AuthenticationService.$inject = ['$http', '$cookieStore', '$rootScope', '$timeout', 'UserService'];

function AuthenticationService($http, $cookieStore, $rootScope, $timeout, UserService) 
{
	//Service factory methods, contains all HTTP calls 
	var service = {};
	service.Login = Login;
	service.Registration = Registration;
	service.FetchAllDefects = FetchAllDefects;
	service.GetManagers = GetManagers;
	service.SetCredentials = SetCredentials;
	service.ClearCredentials = ClearCredentials;
	service.InvalidateSession = InvalidateSession;
	return service;

	
	// Login Function, will authenticate user and set global variables
	function Login(username, password, callback)
	{
		var response;
		$timeout(function () {
			var response;
			// authenticate user by using the users table
			$http({
				method : 'POST',
				url : '/AuthenticateUser',
				headers: {'Content-Type': 'application/json'},
				data : {
					'username' : username,
					'password' : password
				}
			}).then(function successCallback(response){
				//success case
				$rootScope.sessionid = response.data.sessionID;
				var msg = response.data.authmessage;
				console.log("Function Login():success: "+msg);
				// set response object
				response = { success : true, message : msg };
				callback(response);	
				}, function error(response) {
				// failure case
				var msg = response.data.authmessage;
				console.log("Function Login():failure: "+msg);
				// set response object
				response = { success : false, message : msg };
				callback(response);
			});
		}, 1000);
	}
	

	function Registration(user,callback)
	{
		$timeout(function () {
			var response;

			$http({
				method : 'POST',
						url : '/UATDashboard/SetData/Registration',
						headers: {'Content-Type': 'application/json'},
						data : {
							'emp_name' : user.firstName + user.LastName,
							'manager' : user.manager,
							'emp_id' : user.empid,
							'designation' : user.designation,
							'username' : user.username,
							'password' : user.password
						}
					})
						.then(function successCallback(response)
						{
						console.log("User Registraion Succesfull" + response.data);
						response = { success: true};
						callback(response);
						},
						function error(response)
						{
							console.log("User Registraion Failure" + response.data);
							response = { success: false, message: "User Registraion Failure" };
							callback(response);
						});
		}, 5000);
	}
	
	function GetManagers(callback)
	{
		$http({
			method : 'GET',
			url : '/UATDashboard/GetData/GetManagers',
			headers: {'Content-Type': 'application/json'}
		}).then(function successCallback(response){
			console.log("WS call : " + response.data);
			callback(response.data);
		});
	}
	
	function FetchAllDefects(callback)
	{
		$http({
			method : 'GET',
			url : '/UATDashboard/GetData/GetTasks',
			headers: {'Content-Type': 'application/json'}
		}).then(function successCallback(response){
			console.log("WS call : " + response.data);
			callback(response.data);
		});
	}
	
	//set global credentials
    function SetCredentials(username, password) {
        var authdata = Base64.encode(username + ':' + password);

        $rootScope.globals = {
            currentUser: {
                username: username,
                authdata: authdata
            }
        };

        $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata; // jshint ignore:line
        $cookieStore.put('globals', $rootScope.globals);
    }

    //clear all credentials from app
    function ClearCredentials() 
	{
		$rootScope.globals = {};
		$cookieStore.remove('globals');
		$cookieStore.remove('JSESSIONID');
		$http.defaults.headers.common.Authorization = 'Basic';
	}
    
    // invalidate http session
	function InvalidateSession()
	{
		$http({
			method : 'POST',
			params : { 'sessionId': $rootScope.sessionid },
			url : '/InvalidateSession',
		});
	}
}

//Base64 encoding service used by AuthenticationService
var Base64 = {

		keyStr: 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',

		encode: function (input) {
			var output = "";
			var chr1, chr2, chr3 = "";
			var enc1, enc2, enc3, enc4 = "";
			var i = 0;

			do {
				chr1 = input.charCodeAt(i++);
				chr2 = input.charCodeAt(i++);
				chr3 = input.charCodeAt(i++);

				enc1 = chr1 >> 2;
				enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
				enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
				enc4 = chr3 & 63;

				if (isNaN(chr2)) {
					enc3 = enc4 = 64;
				} else if (isNaN(chr3)) {
					enc4 = 64;
				}

				output = output +
				this.keyStr.charAt(enc1) +
				this.keyStr.charAt(enc2) +
				this.keyStr.charAt(enc3) +
				this.keyStr.charAt(enc4);
				chr1 = chr2 = chr3 = "";
				enc1 = enc2 = enc3 = enc4 = "";
			} while (i < input.length);

			return output;
		},

		decode: function (input) {
			var output = "";
			var chr1, chr2, chr3 = "";
			var enc1, enc2, enc3, enc4 = "";
			var i = 0;

			// remove all characters that are not A-Z, a-z, 0-9, +, /, or =
			var base64test = /[^A-Za-z0-9\+\/\=]/g;
			if (base64test.exec(input)) {
				window.alert("There were invalid base64 characters in the input text.\n" +
						"Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
				"Expect errors in decoding.");
			}
			input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

			do {
				enc1 = this.keyStr.indexOf(input.charAt(i++));
				enc2 = this.keyStr.indexOf(input.charAt(i++));
				enc3 = this.keyStr.indexOf(input.charAt(i++));
				enc4 = this.keyStr.indexOf(input.charAt(i++));

				chr1 = (enc1 << 2) | (enc2 >> 4);
				chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
				chr3 = ((enc3 & 3) << 6) | enc4;

				output = output + String.fromCharCode(chr1);

				if (enc3 != 64) {
					output = output + String.fromCharCode(chr2);
				}
				if (enc4 != 64) {
					output = output + String.fromCharCode(chr3);
				}

				chr1 = chr2 = chr3 = "";
				enc1 = enc2 = enc3 = enc4 = "";

			} while (i < input.length);

			return output;
		}
};