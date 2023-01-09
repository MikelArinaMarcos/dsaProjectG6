var object = {"idObjeto": idObjeto, "name": name, "descripcion": descripcion, "precio": precio}

$(document).ready(function(){
    $.get({
        url: '/dsaApp/juego/objetos',
        data: JSON.stringify(object),
        contentType: 'application/json; charset=utf8'
    })
    $('idObjeto').html($('idObjeto').val());
    $('name').html($('name').val());
    $('descripcion').html($('descripcion').val());
    $('precio').html($('precio').val());
});