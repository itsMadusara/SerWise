const nameInput = document.getElementById("nameInput");
let rows = document.getElementsByTagName("table")[1].rows;
let lastRow = rows.length

nameInput.addEventListener("input",function () {
    let id = nameInput.value.toLowerCase();
    for (let i = 1; i < lastRow; i++) {
        if(!(rows[i].cells[1].innerHTML.toLowerCase()).includes(id)){
            rows[i].style.display = "none";
        }
        if((rows[i].cells[1].innerHTML.toLowerCase()).includes(id)){
            rows[i].style.display = "";
        }
    }
})