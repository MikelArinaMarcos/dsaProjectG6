function inicioSesion(){
    var mail = $('#mail').val();
    var password = $('#password').val();
    alert("Hola");
    $.ajax({
        contentType: "application/json",
        type: 'POST',
        url:'/dsaApp/juego/login',
        data: JSON.stringify({"mail": mail, "password": password}),
        success: function(users){
            alert("Welcome, " + mail);
        },
        error: function (error){
            if (mail == "" || password == "")
                alert("Tienes que completar todos los campos.");
            else
                alert("Datos incorrectos.");
        }
    });
};