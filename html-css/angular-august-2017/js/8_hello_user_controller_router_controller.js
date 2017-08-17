var phonecatApp = angular.module('phonecatApp', ["ngRoute"]);

phonecatApp.config(function ($routeProvider) {
  $routeProvider
          .when("/", {
            template: "<h1>Main</h1><p>Click on the links to change this content</p>"
          })
          .when("/red", {
            templateUrl: "red.html",
            controller: "londonCtrl"
          })
          .when("/green", {
            templateUrl: "green.html",
            controller: "parisCtrl"
          })
          .when("/blue", {
            templateUrl: "blue.html"
          })
          .otherwise({
            template: "<h1>None</h1><p>Nothing has been selected</p>"
          });
});

phonecatApp.controller("londonCtrl", function ($scope) {
  $scope.msg = "I love Paris";
});
phonecatApp.controller("parisCtrl", function ($scope) {
  $scope.msg = "I love London";
});

phonecatApp
        .controller('ParentController', function ($scope) {
          $scope.foo = "bar";
        })
        .controller('ChildController', function ($scope) { /*empty*/
        });

phonecatApp
        .controller('ParentController2', function ($scope) {
          $scope.obj = {
            foo: "bar"
          };
        })
        .controller('ChildController2', function ($scope) { /*empty*/
        });


phonecatApp
        .controller('ParentController3', function () {
          this.foo3 = "bar";
        })
        .controller('ChildController3', function () { /*empty*/
        });

