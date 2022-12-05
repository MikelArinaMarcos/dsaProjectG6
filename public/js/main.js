$(document).ready(function(){
    var $users = $('#users');
    $.ajax({
        type: 'GET',
        url:'/dsaApp/juego',
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