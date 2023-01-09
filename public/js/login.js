$(document).ready(function(){
    $("#myForm").submit(function(event){
        inicioSesion(event);
    });
});

function inicioSesion(event){
    event.preventDefault();
    var mail = $('#mail').val();
    var password = $('#password').val();
    $.post({
        url: '/dsaApp/juego/login',
        data: JSON.stringify({"mail": mail, "password": password}),
        contentType: 'application/json; charset=utf8'
    })
        .done(function (data, status){
            alert("Welcome");
            document.location= "/html/informacion.html";
        })
        .fail(function(xhr, err){
            alert("Usuario o contraseña incorrectos");
            //document.location = "/html/login.html";
        })
};

