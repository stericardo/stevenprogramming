/**
 * @ngdoc component
 * @name stevenApp.products
 * @description Detail  controller
 */
angular.module('stevenApp.detail').controller("detailController", function ($scope, $log, $routeParams, detailService) {
    var currentId = $routeParams.id;
    var vm = this;
    detailService.getProduct(currentId)
            .then(function (product) {
                vm.product = product;
            })
            .catch(function (err) {
                // Tratar el error
            });
});

