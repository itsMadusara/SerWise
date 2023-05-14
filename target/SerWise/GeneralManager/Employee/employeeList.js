const idInput = document.getElementById("idInput");
const firstNameInput = document.getElementById("firstNameInput");
let rows = document.getElementById("dataTable").rows;
let lastRow = rows.length

idInput.addEventListener("input",function () {
    let id = idInput.value;
    for (let i = 1; i < lastRow; i++) {
        if(!(rows[i].cells[0].innerHTML).includes(id)){
            rows[i].style.display = "none";
        }
        if((rows[i].cells[0].innerHTML).includes(id)){
            rows[i].style.display = "";
        }
    }
})

firstNameInput.addEventListener("input",function () {
    let name = firstNameInput.value.toLowerCase();
    for (let i = 1; i < lastRow; i++) {
        if(!(rows[i].cells[1].innerHTML.toLowerCase()).includes(name)){
            rows[i].style.display = "none";
        }
        if((rows[i].cells[1].innerHTML.toLowerCase()).includes(name)){
            rows[i].style.display = "";
        }
    }
})