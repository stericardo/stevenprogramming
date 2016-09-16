function Person(name, email, message, website){
    this.name=name;
    this.email=email;
    this.message=message;
    this.website = website;
};

function printPerson(person){
    console.log("name " + person.name + " email " + person.email + " website " + person.website + " message " + person.message);
};



