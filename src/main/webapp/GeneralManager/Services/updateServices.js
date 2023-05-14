const container = document.getElementById("branchDiv");
const addButton = document.getElementById("addBranch");
const rmButton = document.getElementById("rmBranch");
const noBranch = document.getElementById("noBranch");
let i = parseInt(noBranch.getAttribute('value'));

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
    if (i>0){
        const rmfeild = document.getElementById('branchid'+i);
        container.removeChild(rmfeild);
        i=i-1
        noBranch.setAttribute('value',i);
    }
});

let noOfBranchNow = parseInt(document.getElementById('noBranchNow').getAttribute('value'));
let buttons = [];
for (let j = 0; j < noOfBranchNow; j++) {
    buttons.push("buttonbranchidnow"+j);
}

for (let i = 0; i < buttons.length; i++) {
    document.getElementById(buttons[i]).addEventListener("click",function () {
        let branchid = document.getElementById(buttons[i]).getAttribute('value');
        let serviceId = document.getElementById('serviceId').getAttribute('value');
        let url = "http://localhost:8081/SerWise_war/deleteServiceBranch?branchId="+branchid+"&serviceId="+serviceId;
        console.log(url)
        fetch(url);
        document.getElementById(buttons[i]).setAttribute("class","hidden");
        document.getElementById("branchidnow"+i).setAttribute("class","hidden");
    });
}

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
    if (j>0){
        const rmfeild1 = document.getElementById('itemid'+j);
        const rmfeild2 = document.getElementById('itemidQty'+j);
        itemContainer.removeChild(rmfeild1);
        itemContainer.removeChild(rmfeild2);
        j=j-1;
        noItems.setAttribute('value',j);
    }
});

let noOfItemsNow = parseInt(document.getElementById('noItemsNow').getAttribute('value'));
let itemButtons = [];
for (let j = 0; j < noOfItemsNow; j++) {
    itemButtons.push("buttonitemidnow"+j);
}

for (let i = 0; i < itemButtons.length; i++) {
    document.getElementById(itemButtons[i]).addEventListener("click",function () {
        let itemId = document.getElementById(itemButtons[i]).getAttribute('value');
        let serviceId = document.getElementById('serviceId').getAttribute('value');
        let url = "http://localhost:8081/SerWise_war/deleteItemService?itemId="+itemId+"&serviceId="+serviceId;
        fetch(url);
        document.getElementById("itemIdDiv"+i).setAttribute("class","hidden");
        // document.getElementById(itemButtons[i]).setAttribute("class","hidden");
        // document.getElementById("itemidnow"+i).setAttribute("class","hidden");
        // document.getElementById("itemQtynow"+i).setAttribute("class","hidden");
    });
}

//Item Div Pop-up code
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