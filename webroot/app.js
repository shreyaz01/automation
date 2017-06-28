    angular
        .module('app', ['ngRoute', 'ngCookies' , 'angularSpinner' , 'ui-notification' , 'xeditable', 'ngTable'])
        .config(config)
        .config(function(NotificationProvider) {
        	NotificationProvider.setOptions({
	            delay: 10000,
	            startTop: 20,
	            startRight: 10,
	            verticalSpacing: 20,
	            horizontalSpacing: 50,
	            positionX: 'center',
	            positionY: 'top',
	            replaceMessage: true,
	        });})
        .run(run);
    
    // this js file is used to route pages during app flow.
    // this is used to initialize the view and its controller.
    // when any new web page is added, make its entry here and use $location on any page
    
    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/adminhome', {
                controller: 'AdminHomeController',
                templateUrl: 'adminhome/adminhome.view.html',
                controllerAs: 'vm'
            })
            
            .when('/userhome', {
                controller: 'UserHomeController',
                templateUrl: 'userhome/userhome.view.html',
                controllerAs: 'vm'
            })

            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'login/login.view.html',
                controllerAs: 'vm'
            })

             .when('/dashboard', {
                // controller: 'DashboardController',
                templateUrl: 'dashboard/dashboard.view.html',
                controllerAs: 'vm'
            })

            .when('/admindefect', {
                controller: 'AdminDefectController',
                templateUrl: 'defect/admindefect.view.html',
                controllerAs: 'vm'
            })

            .when('/userdefect', {
                controller: 'UserDefectController',
                templateUrl: 'defect/userdefect.view.html',
                controllerAs: 'vm'
            })
            
            .when('/people', {
                controller: 'PeopleController',
                templateUrl: 'people/people.view.html',
                controllerAs: 'vm'
            })            
            
            .when('/userenv', {
                controller: 'UserEnvController',
                templateUrl: 'env/userenv.view.html',
                controllerAs: 'vm'
            })   
            
            .when('/adminenv', {
                controller: 'AdminEnvController',
                templateUrl: 'env/adminenv.view.html',
                controllerAs: 'vm'
            })   

            .when('/register', {
                controller: 'RegistrationController',
                templateUrl: 'registration/registration.view.html',
                controllerAs: 'vm'
            })
            
            .otherwise({ redirectTo: '/login' });
    }
    
    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        // decides which all pages are accessible to user whithout logging in, if in future user registration page is created, add that page in 
        // the array list below.
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login','/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

    /*==============================
    =            Toggle            =
    ==============================*/ 
    
    /*=====  End of Toggle  ======*/
