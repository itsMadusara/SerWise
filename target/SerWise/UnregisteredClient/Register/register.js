const password = document.getElementById('password');
const confirm_password = document.getElementById('confirm_password');

password.addEventListener('input', function() {
    const pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+}{":;'?/>.<,])(?!.*(.)\1\1)[0-9a-zA-Z!@#$%^&*()_+}{":;'?/>.<,]{8,}$/;
    const pass = password.value;
    if (pass.match(pattern)) {
        password.setCustomValidity('');
    } else {
        password.setCustomValidity('Password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one number, and one special character.');
    }
});

confirm_password.addEventListener('input', function() {
    if (confirm_password.value !== password.value) {
        confirm_password.setCustomValidity("Passwords do not match");
    } else {
        confirm_password.setCustomValidity('');
    }
});












