var BASE_URI="http://147.83.7.208:8080/dsaApp";

$(document).ready(function(){

    $('#signupButton').click(function(){
        var username = $('#username').val();
        console.log(username);
        var password = $('#password').val();
        console.log(password);
        var mail = $('#mail').val();
        console.log(mail);
        var name = $('#name').val();
        console.log(name);
        var lastname = $('#lastname').val();
        console.log(lastname);
        var confirm = $('#confirmpassword').val();
        console.log(confirm);

        if(password=confirm){
            var user = {"username": username, "password": password, "mail": mail, "name": name, "lastname": lastname};
            console.log(user);
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("users/registerUser"),
                headers: {'content-type': 'application/json',"x-kii-appid": "XXXXX","x-kii-appkey":"XXXXX"},
                data: JSON.stringify(user),
                dataType: 'json',
                success: function (data){
                    console.log("Usuario creado correctamente");
                    console.log(data);
                    alert('Regitro completo. ¡Ya formas parte de PLANET EETAC!');
                    // Datos que trasladamos al perfil
                    var username = data.username;
                    var name = data.name;

                    window,sessionStorage.setItem("username", username);
                    window.sessionStorage.setItem("name", name);

                    var url ="http://147.83.7.208:8080/html/myprofile.html";
                    window.open(url, "_self");
                },
                error: function(error){
                    console.log(error);
                }
            });
        }
        else {
            alert("The passwords are different\n");
        }
    });
});