/**
 * @ngdoc component
 * @name stevenApp.products
 * @description Products controller
 */
angular.module('stevenApp.products').controller("productsController", function ($scope, $log, productService) {

    var promise = productService.getProducts();
    promise.then(
            function (response) {
                $scope.products = response.data.products;
            },
            function (errorResponse) {
                $log.error('failure loading products', errorResponse);
            });

});

