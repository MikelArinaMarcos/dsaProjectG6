/******************************************/
/* JAVASCRIPT PARA EL PROCESO DE REGISTRO */
/******************************************/

// Accedemos a la función que se ejecuta al pulsar el botón de "Registro" en el formulario.
function registro(){
    // Nos creamos variables para recoger los datos del formulario.
    alert("Hola");
    var name = $('#name').val();
    console.log(name);
    var password = $('#password').val();
    console.log(password);
    var mail = $('#mail').val();
    console.log(mail);
    var username = $('#name').val();
    console.log(username);
    var lastName = $('#lastName').val();
    console.log(lastName);
    var dinero = 0;
    console.log(dinero);

    // Creamos el nuevo usuario
    $.post({
        url: '/dsaApp/juego/users/register',
        data: JSON.stringify({
            "name": name,
            "password": password,
            "mail": mail,
            "username": username,
            "lastName": lastName,
            "dinero": dinero
        }),
        contentType: 'application/json; charset=utf8'
    })
        // Comprobamos si se ha podido crear y mostramos mensaje con el resultado.
        .done(function (data, status){
            alert("Usuario registrado correctamente.");
            window.location = "../html/informacion.html";
        })
        .fail(function(xhr, err){
            alert("Por favor, revisa los datos introducidos");
            location.reload();
        })
};