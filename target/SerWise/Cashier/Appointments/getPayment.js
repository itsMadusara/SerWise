const totalAmount = document.getElementById("total-amount");
const totalBox = document.getElementById("total-box");
const paidBox = document.getElementById("paid-amount-box");
const balanceBox = document.getElementById("balance-amount-box");

totalBox.setAttribute("value",totalAmount.innerHTML);

paidBox.addEventListener("input",function () {
    let paid = paidBox.value;
    let total = parseInt(totalAmount.innerHTML);
    balanceBox.setAttribute("value",(paid-total));
})