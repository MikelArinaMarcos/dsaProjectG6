const mail = document.getElementById('mail')
const pass = document.getElementById('password')
const button = document.getElementById('button')
const error = document.getElementById('error')

function inicioSesion(){
    const data = {
        mail: mail.value,
        pass: pass.value
    }
    console.log(data)
    return false;
}
