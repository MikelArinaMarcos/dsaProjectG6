$(document).ready(function(){
    var $users = $('#users');
    var username = $('#username');
    var password = $('#password');
    $.ajax({
        contentType: "application/json",
        type: 'POST',
        url:'/dsaApp/login',
        data: JSON.stringify({"username": username, "password": password}),
        success: function(users){
            alert("Welcome, " + username);
        },
        error: function (error){
            if (username == "" || password == "")
                alert("Tienes que completar todos los campos.");
            else
                alert("Datos incorrectos.");
        }
    });
});