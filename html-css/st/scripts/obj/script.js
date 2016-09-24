var Saludator = function(nom) {
    this.nombre = nom
    this.saluda = function() {
        alert("hola "+this.nombre)
    }
}

// Agrega un objeto al prototipo
Saludator.prototype = {
    apellido: "EMPTY",
    saludar: function() {
        console.log("Hola "+this.nombre+" "+this.apellido)
    },
    setApellido: function(value){
        this.apellido = value;
    },
    saludar2: function() {
        console.log("Hola "+this.nombre+" "+this.apellido)
    },
    setApellido2: function(value){
        this.apellido = value;
    }
}

var Saludator2 = function(nom) {
    this.nombre = nom
    apellido: "EMPTY",
    this.saluda = function() {
        alert("hola "+this.nombre)
    },
    this.saludar= function() {
        console.log("Hola "+this.nombre+" "+this.apellido)
    },
    this.setApellido= function(value){
        this.apellido = value;
    },
    this.saluda2 = function() {
        alert("hola "+this.nombre)
    },
    this.saludar2= function() {
        console.log("Hola "+this.nombre+" "+this.apellido)
    },
    this.setApellido2= function(value){
        this.apellido = value;
    }
}

var arr = [];
    var arr2 = [];
    
    
    var arr3 = [];
    var arr4 = [];

$(document).ready(function(){
    console.log("READY JQUERY OBJECT");
    var obj1 = new Saludator("Steven");
    obj1.setApellido("Mendez");
    obj1.saludar(); 
    
    var obj2 = new Saludator2("Steven");
    obj2.setApellido("Mendez");
    obj2.saludar(); 
    
    for (var i = 0; i < 1000; i++) {
        arr.push(new Saludator("Steven"));
        arr2.push(new Saludator2("Steven"));
    }
    
    for (var i = 0; i < 10000; i++) {
        arr3.push(new Saludator("Steven"));
        arr4.push(new Saludator2("Steven"));
    }
    
    /* Not Working we should use prototype
    Saludator2.saluda3= function() {
        console.log("3 hola solo con el proto "+this.nombre)
    };
    */
    Saludator2.prototype.saluda3= function() {
        console.log("3 hola solo con el proto "+this.nombre)
    };
    
    Saludator.prototype.saluda3= function() {
        console.log("3 hola "+this.nombre)
    };
    
    arr3[3].saluda3();
    console.log(Saludator2);
    var obj3 = new Saludator2("Steven 3");
    obj3.saluda3();
    arr4[3].saluda3();
    
    arr4[3].saluda4= function() {
        console.log("saludo 4 "+this.nombre)
    };
    arr4[3].saluda4();
    arr4[4].saluda3();
    arr4[4].saluda4();// That not work because is not part of prototype. 
    //Only of object>>> arr4[3]
    
    
});

