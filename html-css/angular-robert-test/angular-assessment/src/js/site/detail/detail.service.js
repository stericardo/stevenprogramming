/**
 * @ngdoc component
 * @name stevenApp.products
 * @description Products Service
 */
angular.module('stevenApp.detail').service('detailService',
        function detailServiceMethod($http, $log, $q) {

            function getProductId(id) {
                var defered = $q.defer();
                var promise = defered.promise;
                $http.get('http://stevenprogramming.com/servicesjson/angular-products.php')
                        .then(function mySuccess(response) {
                            var listProducts = response.data.products;
                            var product;
                            id = id.substring(1);
                            listProducts.forEach(function (key) {
                                if(key.id === id){
                                    product = key;
                                }
                            });
                            defered.resolve(product);
                        }, function myError(err) {
                            defered.reject(err);
                        });
                return promise;
            }

            return {
                getProduct: function (id) {
                    return getProductId(id);
                }
            };
        }
);