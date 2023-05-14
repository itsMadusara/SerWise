const password = document.getElementById('password');
const confirm_password = document.getElementById('confirm_password');
const button=document.getElementById('submitButton');

const bcrypt = dcodeIO.bcrypt;
const salt = bcrypt.genSaltSync(10);

button.addEventListener('submit',function (){
    const hash = bcrypt.hashSync(password.value, salt);
    console.log(hash);
    password.value=hash;
    confirm_password.value=hash;
});

