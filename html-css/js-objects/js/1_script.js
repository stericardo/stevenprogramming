angular.module('HelloUserApp', [])
        .controller('HelloUserController', function ($scope) {
          $scope.NameChange = function () {
            $scope.greeting = "Hello " + $scope.name;
          };
        });

var person = {
  firstName: "John",
  lastName: "Doe",
  age: 50,
  eyeColor: "blue"
};

function person2(first, last, age, eye) {
  this.firstName = first;
  this.lastName = last;
  this.age = age;
  this.eyeColor = eye;
  this.changeName = function (name) {
        this.lastName = name;
    };
}
var myFather = new person2("John", "Doe", 50, "blue");
var myMother = new person2("Sally", "Rally", 48, "green");
myMother.changeName("Doe");
document.getElementById("demo").innerHTML = "My mother's last name is " + myMother.lastName;

person.nationality = "English";
delete person.nationality;   // or delete person["nationality"]; 

var person3 = {
    firstName:"John",
    lastName: "Doe",
    fullName: function() {
        return this.firstName + " " + this.lastName;
    }
}
var myObject = {
    firstName:"Mary",
    lastName: "Doe Test Steven",
}
person3.fullName.call(myObject);  // Will return "Mary Doe"

document.getElementById("demo").innerHTML = person3.fullName.call(myObject);

var add = (function () {
    var counter = 0;
    return function () {return counter += 1;}
})();

add();
add();
add();

document.getElementById("demo").innerHTML = add();

function person4(name) {
  
  return {
    greet: function() {
      console.log('hello from ' + name)
    }
  }
  
}

let alex = person4('alex');
alex.greet(); // hello from alex

console.log(name); // will throw ReferenceError

console.log(alex.name); // undefined

function Person5(firstName, lastName, age) {
  
  var private = 'this is a private member';

  return {
    getName: function() {
      console.log('My name is ' + firstName + ' ' + lastName);
    },
    getAge: function() {
      console.log('I am ' + age + ' years old')
    }
  }

}

var person5 = new Person5('Alex', 'Kondov', 22);
person5.getName();
person5.getAge();
console.log(person5.private); //undefined

function creaSumador(x) {
  return function(y) {
    return x + y;
  };
}

var suma5 = creaSumador(5);
var suma10 = creaSumador(10);

console.log(suma5(2));  // muestra 7
console.log(suma10(2)); // muestra 12 