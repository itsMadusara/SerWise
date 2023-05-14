//Profile Picture Upload
let imageUpload = document.getElementById("upoadedImage");

imageUpload.addEventListener("input" , function() {
    let selectedFiles = imageUpload.files;
    let selectedFile = selectedFiles[0];

    let formData = new FormData();
    formData.append('profilePic',selectedFile);

    fetch('http://localhost:8081/SerWise_war/uploadProfilePicture', {
        method: "POST",
        body: formData,
    })
        .then(res => res.text())
        .then(data => console.log(data))
        .catch(err => console.log(err));

    location.reload(true);
    // window.location.href = "http://localhost:8081/SerWise_war/Profile";
})


// Password Change
const modal = document.getElementById("passwordDiv");
const btn = document.getElementById("passwordChange");
const closebtn = document.getElementById("closebtn");
const otpdivbtn = document.getElementById("OPTDivbtn");

btn.addEventListener("click",function() {
    modal.style.display = "block";
})
closebtn.addEventListener("click",function () {
    modal.style.display = "none";
})


otpdivbtn.addEventListener("click",function () {
    fetch('http://localhost:8081/SerWise_war/generateOtp')
        .then(res => res.text())
        .then(data => console.log(data));
})

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

