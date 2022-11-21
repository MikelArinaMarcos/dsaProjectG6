
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
        }
        else
            alert("The passwords are different\n");
    });
});
