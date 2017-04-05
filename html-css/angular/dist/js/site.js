/**
 * @ngdoc module
 * @name metroApp.invoice
 * @description # Invoice module
 */

angular.module('metroApp.invoice', []);


/**
 * @ngdoc controller
 * @name metroApp.invoice.InvoiceController
 * @description # Invoice controller
 *
 * @requires $window
 */

angular.module('metroApp.invoice')
    .controller('InvoiceController', ["$window", function ($window) {
        'use strict';

        this.qty = 1;
        this.cost = 2;
        this.inCurr = 'EUR';
        this.currencies = ['USD', 'EUR', 'CNY'];
        this.usdToForeignRates = {
            USD: 1,
            EUR: 0.74,
            CNY: 6.09
        };

        this.total = function total(outCurr) {
            return this.convertCurrency(this.qty * this.cost, this.inCurr, outCurr);
        };

        this.convertCurrency = function convertCurrency(amount, inCurr, outCurr) {
            return amount * this.usdToForeignRates[outCurr] / this.usdToForeignRates[inCurr];
        };

        this.pay = function pay() {
            $window.alert("Thanks!");
        };
    }]);

angular.module('metroApp', [
    'metroApp.invoice'
]);