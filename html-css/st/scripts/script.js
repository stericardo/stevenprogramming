//

$(document).ready(function(){
    console.log("READY JQUERY");
    $( "#contact_form" ).submit(function( event ) {
        console.log("submit JQUERY");
        event.preventDefault();
    });

});

