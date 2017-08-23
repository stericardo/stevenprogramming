angular.module('stevenApp', ["ngRoute", "stevenApp.home", "stevenApp.products", "stevenApp.detail"]);

angular.module('stevenApp').config(function ($routeProvider) {
  $routeProvider
          .when("/", {
            templateUrl: "views/home.html"
          })
          .when("/products", {
            templateUrl: "views/products.html",
            controller: "productsController"
          })
          .when('/products/details/:id', {
            templateUrl: "views/detail.html",
            controller: "detailController"
          })
          .otherwise({
            template: "<h1>None</h1><p>Nothing has been selected</p>"
          });
});