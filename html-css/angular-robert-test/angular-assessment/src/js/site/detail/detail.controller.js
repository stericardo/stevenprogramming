/**
 * @ngdoc component
 * @name stevenApp.products
 * @description Detail  controller
 */
angular.module('stevenApp.detail').controller("detailController", function ($scope, $log, $routeParams, detailService) {
    var currentId = $routeParams.id;
    detailService.getProduct(currentId, $scope);
});

