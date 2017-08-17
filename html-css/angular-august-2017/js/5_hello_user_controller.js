var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.filter('myFormat', function() {
    return function(x) {
        var i, c, txt = "";
        for (i = 0; i < x.length; i++) {
            c = x[i];
            if (i % 2 == 0) {
                c = c.toUpperCase();
            }
            txt += c;
        }
        return txt;
    };
});

phonecatApp.controller('namesCtrl', function($scope) {
    $scope.names = ['Jani', 'Carl', 'Margareth', 'Hege', 'Joe', 'Gustav', 'Birgit', 'Mary', 'Kai'];
    $scope.cars = [
    {model : "Ford Mustang", color : "red"},
    {model : "Fiat 500", color : "white"},
    {model : "Volvo XC90", color : "black"}
    ];
    $scope.cars2 = {
    car01 : "Ford",
    car02 : "Fiat",
    car03 : "Volvo"
    };
    $scope.cars3 = {
      car01 : {brand : "Ford", model : "Mustang", color : "red"},
      car02 : {brand : "Fiat", model : "500", color : "white"},
      car03 : {brand : "Volvo", model : "XC90", color : "black"}
      };
})

phonecatApp.filter('myFormat2',['hexafy', function(hexafy) {
    return function(x) {
        return hexafy.myFunc(x);
    };
}]);

phonecatApp.service('hexafy', function() {
    this.myFunc = function (x) {
        return x.toString(16);
    }
});

phonecatApp.controller('namesCtrl2', function($scope) {
    $scope.data = 255;
})

phonecatApp.controller('myCtrl3', function($scope) {
    $scope.counts = [255, 251, 200];
});

phonecatApp.filter('myFormat3',['hexafy', function(hexafy3) {
    return function(x) {
        return hexafy3.myFunc(x);
    };
}]);

phonecatApp.service('hexafy3', function() {
    this.myFunc = function (x) {
        return x.toString(16);
    }
});

