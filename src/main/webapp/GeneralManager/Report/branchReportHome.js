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
            const branchListContainer = document.getElementById("branchId");
            branchListContainer.appendChild(option);
        }
    });