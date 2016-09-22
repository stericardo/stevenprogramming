$(document).ready(function(){
    console.log("READY JQUERY");
    $( "#contact_form" ).submit(function( event ) {
        event.preventDefault();
        validateForm($('#contact_form :input'));
    });

});

