fetch('http://localhost:8081/SerWise_war/branchLocation')
    .then(res =>{
        return res.text();
    })
    .then(data => {
        data = data.slice(0,-1);
        data = data.split(",");
        var branchIdNow = document.getElementById("BranchIdNow").getAttribute("value");
        const branchListContainer = document.getElementById("BranchId");
        for (const i of data) {
            var temp = i.split("**");
            const option = document.createElement("option")
            console.log(temp[0]);
            if(temp[0]==branchIdNow){
                console.log(branchIdNow);
                option.setAttribute("selected","true");
            }
            option.innerText = temp[1];
            option.setAttribute('value',temp[0]);
            branchListContainer.appendChild(option);
        }
    });

let branchManagerOption = document.getElementById("branchManagerOption");
let branchIdDiv = document.getElementById("BranchId");

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