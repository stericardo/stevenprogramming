var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('formCtrl', function ($scope) {
  $scope.master = {firstName: "John", lastName: "Doe"};
  $scope.reset = function () {
    $scope.user = angular.copy($scope.master);
  };
  $scope.reset();
});

phonecatApp.directive('myDirective', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attr, mCtrl) {
            function myValidation(value) {
                if (value.indexOf("e") > -1) {
                    mCtrl.$setValidity('charE', true);
                } else {
                    mCtrl.$setValidity('charE', false);
                }
                return value;
            }
            mCtrl.$parsers.push(myValidation);
        }
    };
});

phonecatApp.controller('validateCtrl', function($scope) {
    $scope.user = 'John Doe';
    $scope.email = 'john.doe@gmail.com';
});


