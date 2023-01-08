$(document).ready(function(){
    $.get({
        url: '/dsaApp/juego/objetos',
        data: JSON.stringify(body),
        contentType: 'application/json; charset=utf8'
    })
    var idObjeto = $('#idObjeto').val();
    var nombre = $('#name').val();
    var descripcion = $('#password').val();
    var precio = $('#mail').val();
    var body = {"name": name, "password": password, "mail": mail, "username": username, "lastName": lastName
    };
});