/**
 * @ngdoc component
 * @name stevenApp.products
 * @description Products Service
 */
angular.module('stevenApp.products').factory('productService',
        function productsFactory($http) {

            function getListProducts() {
                return $http.get('http://stevenprogramming.com/servicesjson/angular-products.php');
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