const nav = document.querySelector('.navigation');

const innerText = "<img src=\"/SerWise_war/Assets/SerWise.png\" class=\"navimg\">\n" +
    "<table>\n" +
    "    <tr>\n" +
    "        <td><a href=\"/SerWise_war/StoreKeeper/Home/home.jsp\" class=\"nava\">Home</a></td>\n" +
    "        <td><a href=\"/SerWise_war/StoreKeeper/Order/order.jsp\" class=\"nava\">Issue Items</a></td>\n" +
    "        <td><a href=\"/SerWise_war/StoreKeeper/Inventory/inventory.jsp\">Inventory</a></td>\n" +
    "        <td><a href=\"/SerWise_war/StoreKeeper/Reorder/reorder.jsp\">Reorder Items</a></td>\n" +
    "        <td><a href='/SerWise_war/ServletLogout'><button class=\"button\">Logout</button></a></td>\n" +
    "        <td><a href=\"#\"><img src=\"/SerWise_war/Assets/ProfilePic.jpg\" class=\"profile\"></a></td>\n" +
    "    </tr>\n" +
    "</table>";

nav.innerHTML=innerText;