angular.module('HelloUserApp', [])
        .controller('HelloUserController', function ($scope) {
          $scope.NameChange = function () {
            $scope.greeting = "Hello " + $scope.name;
          };
        })
        .controller('AddNumbersController', function ($scope) {
          $scope.AddNumbers = function () {
            var a = Number($scope.c || 0);
            var b = Number($scope.d || 0);
            $scope.sum = a + b;
          };
        })
        .controller("CounterController", function ($scope) {
          $scope.counter3 = 0;
          $scope.decrement = function () {
            $scope.counter3--;
          };
        })
        .controller('CounterController2', function ($scope, $timeout) {
          $scope.counter4 = 0;
          var updateCounter = function () {
            $scope.counter4++;
            $timeout(updateCounter, 1000);
          };
          updateCounter();
        })
        .controller('CounterController3', function ($scope, $timeout) {
          var timer;
          $scope.counter5 = 0;
          $scope.stopCounter = function () {
            $timeout.cancel(timer);
          };
          var updateCounter = function () {
            $scope.counter5++;
            timer = $timeout(updateCounter, 1000);
          };
          updateCounter();
        })
        .controller('CounterController4', function ($scope, $timeout) {
          var timer;
          $scope.counter6 = 0;
          $scope.stopCounter = function () {
            $timeout.cancel(timer);
            timer = null;
          };
          $scope.startCounter = function () {
            if (timer === null) {
              updateCounter();
            }
          };
          var updateCounter = function () {
            $scope.counter6++;
            timer = $timeout(updateCounter, 1000);
          };
          updateCounter();
        })
        .controller('CalculatorController', function ($scope) {
          $scope.result = function () {
            if ($scope.operator == '+') {
              return $scope.a + $scope.b;
            }
            if ($scope.operator == '-') {
              return $scope.a - $scope.b;
            }
            if ($scope.operator == '*') {
              return $scope.a * $scope.b;
            }
            if ($scope.operator == '/') {
              return $scope.a / $scope.b;
            }
          };
        })
        .controller('todoController', function ($scope) {
          $scope.tasks = [];
          $scope.add = function () {
            $scope.tasks.push($scope.title);
            $scope.title = ""; 
          },
          $scope.add2 = function () {
            $scope.tasks.push($scope.title2);
            $scope.title2 = ""; 
          }
        });