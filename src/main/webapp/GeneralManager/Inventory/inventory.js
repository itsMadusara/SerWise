const container = document.getElementById("branchDiv");
const addButton = document.getElementById("addBranch");
const rmButton = document.getElementById("rmBranch");
const noBranch = document.getElementById("noBranch");
let i = parseInt(noBranch.getAttribute('value'));

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
        const branchListContainer = document.getElementById("branchid1");
        branchListContainer.appendChild(option);
      }
    });

addButton.addEventListener("click", function() {
  const select = document.createElement("select");
  i++;
  select.setAttribute('id','branchid'+i);
  select.setAttribute('name','branchid'+i);
  noBranch.setAttribute('value',i);
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
          select.appendChild(option);
        }
      });
  container.appendChild(select);
});

rmButton.addEventListener("click" , function (){
  if (i>1){
    const rmfeild = document.getElementById('branchid'+i);
    container.removeChild(rmfeild);
    i=i-1
    noBranch.setAttribute('value',i);
  }
});
