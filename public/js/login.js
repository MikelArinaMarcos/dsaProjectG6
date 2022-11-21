$(document).ready(function (){
    $("#loginButton").click(function(){
        var username = $('#username').value();
        console.log(username);
        var password = $('#password').value();
        console.log(password);
        var user = {"username": username, "password": password};
        console.log(user);

    })
})