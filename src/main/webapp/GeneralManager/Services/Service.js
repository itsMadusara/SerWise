//Add Branches in div
const branchContainer = document.getElementById("branchDiv");
const addBranchButton = document.getElementById("addBranch");
const branchRmButton = document.getElementById("rmBranch");
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

addBranchButton.addEventListener("click", function() {
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
    branchContainer.appendChild(select);
});

branchRmButton.addEventListener("click" , function (){
    if (i>1){
        const rmfeild = document.getElementById('branchid'+i);
        branchContainer.removeChild(rmfeild);
        i=i-1
        noBranch.setAttribute('value',i);
    }
});

//Branch Div Pop-up code
let branchDivBtn = document.getElementById("addBranchDivBtn");
let branchDivPopup = document.getElementById("branchDivPopup");
let closeBranchDiv = document.getElementById("confirmBranches");

branchDivBtn.addEventListener("click", function () {
    branchDivPopup.style.display = "block";
})

closeBranchDiv.addEventListener("click", function () {
    branchDivPopup.style.display = "none";
})

//Add items in Div
const itemContainer = document.getElementById("itemDiv");
const addItemButton = document.getElementById("addItem");
const ItemRmButton = document.getElementById("rmItem");
const noItems = document.getElementById("noItems");
let j = parseInt(noItems.getAttribute('value'));

fetch('http://localhost:8081/SerWise_war/inventoryNames')
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
            const itemListContainer = document.getElementById("itemid1");
            itemListContainer.appendChild(option);
        }
    });

addItemButton.addEventListener("click", function() {
    const select = document.createElement("select");
    j++;
    select.setAttribute('id','itemid'+j);
    select.setAttribute('name','itemid'+j);
    noItems.setAttribute('value',j);
    fetch('http://localhost:8081/SerWise_war/inventoryNames')
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
    const qty = document.createElement("input");
    qty.setAttribute("type","text");
    qty.setAttribute("name","itemidQty"+j);
    qty.setAttribute("id","itemidQty"+j);
    qty.setAttribute("pattern","[0-9]+");
    qty.setAttribute("placeholder","Quantity");
    itemContainer.appendChild(select);
    itemContainer.appendChild(qty);
});

ItemRmButton.addEventListener("click" , function (){
    if (j>1){
        const rmfeild1 = document.getElementById('itemid'+j);
        const rmfeild2 = document.getElementById('itemidQty'+j);
        itemContainer.removeChild(rmfeild1);
        itemContainer.removeChild(rmfeild2);
        j=j-1;
        noItems.setAttribute('value',j);
    }
});

//Branch Div Pop-up code
let itemDivBtn = document.getElementById("addItemDivBtn");
let itemDivPopup = document.getElementById("itemDivPopup");
let closeItemDiv = document.getElementById("confirmItems");

itemDivBtn.addEventListener("click", function () {
    itemDivPopup.style.display = "block";
})

closeItemDiv.addEventListener("click", function () {
    itemDivPopup.style.display = "none";
})

//Clicking on black will close the popup
window.onclick = function(event) {
    if (event.target == branchDivPopup || event.target == itemDivPopup) {
        branchDivPopup.style.display = "none";
        itemDivPopup.style.display = "none";
    }
}