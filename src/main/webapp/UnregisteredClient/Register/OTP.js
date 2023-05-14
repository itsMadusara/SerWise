const otpdivbtn = document.getElementById("OPTDivbtn");
otpdivbtn.addEventListener("click",function () {
    fetch('http://localhost:8081/SerWise_war/generateOtp')
        .then(res => res.text())
        .then(data => console.log(data));
})
