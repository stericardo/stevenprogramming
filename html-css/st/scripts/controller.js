function validateForm(inputs) {
    var values = {};
    inputs.each(function () {
        values[this.name] = $(this).val();
    });
    var myPerson = new Person(values['name'],values['email'],values['message'], values['website']);
    printPerson(myPerson);
    return false;
}

