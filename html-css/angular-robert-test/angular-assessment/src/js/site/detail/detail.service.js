/**
 * @ngdoc component
 * @name stevenApp.products
 * @description Products Service
 */
angular.module('stevenApp.detail').service('detailService',
        function detailServiceMethod($http, $log) {

            function getProductId(id, scopeController) {
                var promise = $http.get('http://stevenprogramming.com/servicesjson/angular-products.php');
                promise.then(
                        function (response) {
                            var listProducts = response.data.products;
                            listProducts.forEach(function (key) {
                                console.log(key, listProducts[key]);
                            });
                            scopeController.product = listProducts[0];
                        },
                        function (errorResponse) {
                            $log.error('failure loading products', errorResponse);
                        });
            }

            return {
                getProduct: function (id, scopeController) {
                    getProductId(id, scopeController);
                }
            };
        }
);