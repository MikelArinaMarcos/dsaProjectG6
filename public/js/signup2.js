/******************************************/
/* JAVASCRIPT PARA EL PROCESO DE REGISTRO */
/******************************************/

// Accedemos a la función que se ejecuta al pulsar el botón de "Registro" en el formulario.
function registro(){
    // Nos creamos variables para recoger los datos del formulario.
    var name = $('#name').val();
    var password = $('#password').val();
    var mail = $('#mail').val();
    var username = $('#name').val();
    var lastName = $('#lastName').val();

    $.post({
        url: '/dsaApp/juego/users/register',
        data: JSON.stringify({
            "name": name,
            "password": password,
            "mail": mail,
            "username": username,
            "lastName": lastName
        }),
        contentType: 'application/json; charset=utf8'
    })
        .done(function (data, status){
            alert("Usuario registrado correctamente.");
            window.location = "../html/informacion.html";
        })
        .fail(function(xhr, err){
            alert("Por favor, revisa los datos introducidos");
            location.reload();
        })
};