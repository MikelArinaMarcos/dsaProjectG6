var BASE_URI="http://147.83.7.208:8080/dsaApp";

$(document).ready(function(){
    var $users = $('#users');
    $.ajax({
        type: 'GET',
        url: BASE_URI.concat("/users/getUsers"),
        success: function(users){
            $.each(users, function (i, user){
                $users.append('<li>username: '+user.username+' mail: '+user.mail+' name: '+user.name+' lastname: '+user.lastname+' </li>');
            });
        },
        error: function (){
            alert('Se produjo un error cargando los usuarios.');
        }
    });
});