function Person(name, email, message, website){
        this.name = name;
        this.email = email;
        this.message = message;
        this.website = website;
};
        

Person.prototype = {
        type: 'O positive',
        printPerson: function(){
            console.log("Printing values name " + this.name + " email " + this.email + 
                        " website " + this.website + " message " + this.message);
        },
        printPersonName: function(){
            console.log("Printing values name >> " + this.getName() + " email " + this.email + 
                        " website " + this.website + " message " + this.message);
        },
        getName: function () {
            return this.name; 
        },
        getEmail: function () {
            return this.email; 
        },
        getType: function () {
            return Person.type; 
        }
}



