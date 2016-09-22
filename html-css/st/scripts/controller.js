function validateForm(inputs) {
    var values = {};
    inputs.each(function () {
        values[this.name] = $(this).val();
    });
    var myPerson = new Person(values['name'],values['email'],values['message'], values['website']);
    myPerson.printPerson();
    console.log("Name >>> " + myPerson.getName());
    myPerson.printPersonName();
    console.log("Type >>> " + myPerson.type);
    var myPerson2 = new Person(values['name'] + "2",values['email'] + "2",values['message'] + "2", values['website'] + "2");
    console.log("Type22 >>> " + myPerson2.type);
    myPerson2.type = "E";
    console.log("Type >>> " + myPerson.type);
    console.log("Type22 >>> " + myPerson2.type);
    console.log("Name >>> " + myPerson.getName());
    console.log("Name22 >>> " + myPerson2.getName());
    Person.type = "Ef";
    console.log("Type >>> " + myPerson.getType());
    console.log("Type22 >>> " + myPerson2.getType());
    console.log("Type >>> " + myPerson.type);
    console.log("Type22 >>> " + myPerson2.type);
    console.log("Name >>> " + myPerson.getName());
    console.log("Name22 >>> " + myPerson2.getName());
    Person.type = "Ef222";
    console.log("Type >>> " + myPerson.getType());
    console.log("Type22 >>> " + myPerson2.getType());
    return false;
}

