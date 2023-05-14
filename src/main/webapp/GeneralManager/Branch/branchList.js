const idInput = document.getElementById("idInput");
let rows = document.getElementsByTagName("table")[1].rows;
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