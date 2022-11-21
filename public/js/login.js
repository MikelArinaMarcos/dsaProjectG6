var BASE_URI="http://147.83.7.208:8080/";

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