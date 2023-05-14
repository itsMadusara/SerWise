// const empIdInput = document.getElementById("empId");
let branchManagerOption = document.getElementById("branchManagerSelect");
let branchIdDiv = document.getElementById("BranchId");

fetch('http://localhost:8081/SerWise_war/branchLocation')
    .then(res =>{
        return res.text();
    })
    .then(data => {
        data = data.slice(0,-1);
        data = data.split(",");
        for (const i of data) {
            var temp = i.split("**");
            const option = document.createElement("option")
            option.innerText = temp[1];
            option.setAttribute('value',temp[0]);
            const branchListContainer = document.getElementById("BranchId");
            branchListContainer.appendChild(option);
        }
    });

branchIdDiv.addEventListener("input",function () {
    let branchId = branchIdDiv.value;
    let fetchUrl = "http://localhost:8081/SerWise_war/checkBranchManager?branchId="+branchId;
    fetch(fetchUrl)
        .then(res =>{
            return res.text();
        })
        .then(data => {
            if (data.length){
                branchManagerOption.setAttribute("class","hidden")
            } else {
                branchManagerOption.setAttribute("class","")
            }
        });
})


// empIdInput.addEventListener("input",function () {
//     let empid = empIdInput.value;
//     let checkLink = "http://localhost:8081/SerWise_war/checkEmployee?empId="+empid;
//     fetch(checkLink)
//         .then(res =>{
//             return res.text()
//         })
//         .then(data => {
//             if(data==empid){
//                 empIdInput.setAttribute("style","background-color:#f7a6a6");
//                 document.getElementById("addEmployeeBtn").disabled = true;
//             } else {
//                 empIdInput.removeAttribute("style");
//                 document.getElementById("addEmployeeBtn").disabled = false;
//             }
//         })
// })