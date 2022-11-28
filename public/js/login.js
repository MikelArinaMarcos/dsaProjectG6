var BASE_URI="http://147.83.7.208:8080/dsaApp"

$(document).ready(function (){
    $("#loginButton").click(function(){
        var username = $('#username').value();
        console.log(username);
        var password = $('#password').value();
        console.log(password);
        var user = {"username": username, "password": password};
        console.log(user);

        $.ajax({
            type: 'POST',
            url: BASE_URI.concat("/auth/login"),
            headers: { 'content-type': 'application/json',"x-kii-appid": "XXXXX","x-kii-appkey":"XXXXX" },
            data: JSON.stringify(user),
            dataType: 'json',
            success: function (data){
                console.log("Se ha iniciado sesión correctamente");
                console.log(data);
                console.log(url);
                var username = data.username;
                var name = data.name;
                // Cogemos los siguientes datos del usuario.
                window.sessionStorage.setItem("username", username);
                window.sessionStorage.setItem("name", name);
                alert('Inicio de sesión correcto');
                // Llevamos al usuario a la página de información de su perfil
                var url = "http://147.83.7.208:8080/html/myprofile.html";
                window.open(url, "_self");
            },
            error: function(error){
                console.log(error.message);
            }
        });
    });
});