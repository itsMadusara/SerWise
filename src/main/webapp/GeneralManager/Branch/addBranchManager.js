let branchManagerInput = document.getElementById("branchManagerId");
let addBranchBtn = document.getElementById("addBranchBtn");

branchManagerInput.addEventListener("input",function () {
    let empid = branchManagerInput.value;
    let checkLink = "http://localhost:8081/SerWise_war/checkEmployee?empId="+empid;
    fetch(checkLink)
        .then(res =>{
            return res.text()
        })
        .then(data => {
            if(!(data==empid)){
                branchManagerInput.setAttribute("style","background-color:#f7a6a6");
                addBranchBtn.disabled = true;
            } else {
                branchManagerInput.removeAttribute("style");
                addBranchBtn.disabled = false;
            }
        })
})