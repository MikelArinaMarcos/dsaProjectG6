function registro(){
    var $username = $('#username').value();
    var $password = $('#password').value();
    var $mail = $('#mail').value();
    var $name = $('#name').value();
    var $lastname = $('#lastname').value();

    $.ajax({
        contentType: "application/json",
        type: 'POST',
        url:'/dsaApp/juego/signup',
        data: JSON.stringify({"username": username, "password": password, "mail": mail, "name": name, "lastname": lastname}),
        success: function(users){
            alert("Usuario creado con éxito");
        },
        error: function (error){
            alert("Error al crear el usuario");
        }
    });
};