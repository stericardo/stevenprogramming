/**
 * @ngdoc component
 * @name stevenApp.products
 * @description Products Service
 */
angular.module('stevenApp.products').factory('productService',
        function productsFactory($http, $q) {

            function getListProducts() {
                var defered = $q.defer();
                var promise = defered.promise;
                $http.get('http://stevenprogramming.com/servicesjson/angular-products.php')
                        .then(function mySuccess(response) {
                            defered.resolve(response.data);
                        }, function myError(err) {
                            defered.reject(err);
                        });
                return promise;
            }

            function getProductId(id) {
                return "products";
            }

            return {
                getProducts: function () {
                    return getListProducts();
                },
                getProduct: function (id) {
                    getProductId(id);
                }
            };
        }
);