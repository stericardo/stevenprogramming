var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('namesCtrl', function($scope) {
    $scope.names = [
        {name:'Jani',country:'Norway'},
        {name:'Carl',country:'Sweden'},
        {name:'Margareth',country:'England'},
        {name:'Hege',country:'Norway'},
        {name:'Joe',country:'Denmark'},
        {name:'Gustav',country:'Sweden'},
        {name:'Birgit',country:'Denmark'},
        {name:'Mary',country:'England'},
        {name:'Kai',country:'Norway'}
        ];
});

phonecatApp.controller('costCtrl', function($scope) {
    $scope.price = 58;
});

phonecatApp.controller('namesCtrlShort', function($scope) {
    $scope.names = [
        'Jani',
        'Carl',
        'Margareth',
        'Hege',
        'Joe',
        'Gustav',
        'Birgit',
        'Mary',
        'Kai'
    ];
});

phonecatApp.controller('namesCtrl2', function($scope) {
    $scope.names = [
        'Jani',
        'Carl',
        'Margareth',
        'Hege',
        'Joe',
        'Gustav',
        'Birgit',
        'Mary',
        'Kai'
    ];
});

phonecatApp.controller('myCtrl', function($scope, $location) {
    $scope.myUrl = $location.absUrl();
});

phonecatApp.controller('myCtrl2', function($scope, $http) {
  $http.get("4_http_response.html").then(function (response) {
      $scope.myWelcome = response.data;
  });
});

//hexafy Service Custom
phonecatApp.service('hexafy', function() {
    this.myFunc = function (x) {
        return x.toString(16);
    }
});

phonecatApp.controller('myCtrl3', function($scope, hexafy) {
    $scope.hex = hexafy.myFunc(255);
});
