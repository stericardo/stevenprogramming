angular.module('metroApp', [
    'ui.router'
]);

angular.module('metroApp')
    .config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/");

        $stateProvider
            .state('home', {
                url: "/",
                templateUrl: "/content/training/day7.html"
            })
            .state('view1', {
                url: "/view1",
                templateUrl: "/content/training/day7.view2.html",
                controller: ["$window", '$scope', function ($window, $scope) {
                    'use strict';

                    $scope.qty = 1;
                    $scope.cost = 2;
                    $scope.inCurr = 'EUR';
                    $scope.currencies = ['USD', 'EUR', 'CNY'];
                    $scope.usdToForeignRates = {
                        USD: 1,
                        EUR: 0.74,
                        CNY: 6.09
                    };

                    $scope.total = function total(outCurr) {
                        return $scope.convertCurrency($scope.qty * $scope.cost, $scope.inCurr, outCurr);
                    };

                    $scope.convertCurrency = function convertCurrency(amount, inCurr, outCurr) {
                        return amount * $scope.usdToForeignRates[outCurr] / $scope.usdToForeignRates[inCurr];
                    };

                    $scope.pay = function pay() {
                        $window.alert("Thanks!");
                    };
                }]
            })
            .state('view2', {
                url: "/view2",
                templateUrl: "/content/training/day7.view2.html"
            });
    }]);