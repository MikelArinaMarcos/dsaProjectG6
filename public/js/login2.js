function inicioSesion(){
    var $users = $('#users').value();
    var $username = $('#username').value();
    var $password = $('#password').value();
    alert("Hola");
    $.ajax({
        contentType: "application/json",
        type: 'POST',
        url:'/dsaApp/juego/login',
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
};