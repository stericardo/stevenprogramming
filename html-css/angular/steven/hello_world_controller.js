var app = angular.module('HelloWorldApp', []);

app.controller('HelloWorldController', function ($scope) {
        $scope.greeting = "Hello World";
	    $scope.title = "Title";    
});

app.controller('HelloUserController', function ($scope) {
    $scope.NameChange = function () {
              $scope.greeting = "Hello " + $scope.name;
          };
});

var items = angular.module('items', []);
var text = angular.module('text', []);
var country = angular.module('country', []);
var appJoined = angular.module('appJoined', ['items', 'text']);


text.controller('TextController', function ($scope) {
	$scope.text = {
		message : 'Welcome!!'
	};
});

country.controller('CountryController', function ($scope) {
	$scope.countries = [
		{
			locale:'en-US',
			name:'United States'
		}, 
		{
			locale:'en-GB',name:'United Kingdom'
		}, 
		{
			locale:'en-FR',name:'France'
		}
	];
});

items.controller('ItemController', function ($scope) {
    $scope.items = [ {
		title : 'Pencil',
		quantity : 8,
		price : 4.2
	}, {
		title : 'Pen',
		quantity : 2,
		price : 5.2
	}, {
		title : 'Watch',
		quantity : 3,
		price : 10.2
	}];
});

var appRoute = angular.module('appRoute', ['ngRoute']);
appRoute.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/', {templateUrl: './partials/views/root.html',   controller: 'rootCtrl'}}).

        when('/section', {templateUrl: './partials/views/section.html',   controller: 'sectionCtrl'}}).

        otherwise({redirectTo: '/'});
}]);
