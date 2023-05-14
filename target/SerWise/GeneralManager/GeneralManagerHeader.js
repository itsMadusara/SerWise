const nav = document.querySelector('.navigation');

const innerText = "<img src=\"/SerWise_war/Assets/SerWise.png\" class=\"navimg\">\n" +
    "<table>\n" +
    "    <tr>\n" +
    "        <td><a href=\"/SerWise_war/GeneralManager/Home/home.jsp\" class=\"nava\">Home</a></td>\n" +
    "        <td><a href=\"/SerWise_war/GeneralManager/Employee/EmployeeHome.jsp\">Employee</a></td>\n" +
    "        <td><a href=\"/SerWise_war/GeneralManager/Services/serviceHome.jsp\">Services</a></td>\n" +
    "        <td><a href=\"/SerWise_war/GeneralManager/Inventory/InventoryHome.jsp\">Inventory</a></td>\n" +
    "        <td><a href=\"/SerWise_war/GeneralManager/Branch/BranchHome.jsp\">Branches</a></td>\n" +
    "        <td><a href=\"/SerWise_war/GeneralManager/Report/reportHome.jsp\">Reports</a></td>\n" +
    "        <td><a href='/SerWise_war/ServletLogout'><button class=\"button\">Logout</button></a></td>\n" +
    "        <td><a href=\"/SerWise_war/Profile\"><img src=\"/SerWise_war/Assets/ProfilePic.jpg\" class=\"profile\"></a></td>\n" +
    "    </tr>\n" +
    "</table>";

nav.innerHTML=innerText;