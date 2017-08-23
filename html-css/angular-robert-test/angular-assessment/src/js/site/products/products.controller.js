/**
 * @ngdoc component
 * @name stevenApp.products
 * @description Products controller
 */
angular.module('stevenApp.products').controller("productsController", function ($scope, $log, productService) {
    var vm = this;
    productService.getProducts()
            .then(function (data) {
                vm.products = data.products;
            })
            .catch(function (err) {
                // Tratar el error
            });


});

