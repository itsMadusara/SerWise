const nav = document.querySelector('.navigation');

const innerText = "<img src=\"/SerWise_war/Assets/SerWise.png\" class=\"navimg\">\n" +
    "        <table>\n" +
    "            <tr>\n" +
    "                <td><a href=\"/SerWise_war/Cashier/Home/home.jsp\" class=\"nava\">Home</a></td>\n" +
    "                <td><a href=\"/SerWise_war/doneJobList\">Jobs</a></td>\n" +
    "                <td><a href=\"/SerWise_war/billedJobList\">Invoices</a></td>\n" +
    "                <td><a href='/SerWise_war/ServletLogout'><button class=\"button\">Logout</button></a></td>\n" +
    "                <td><a href=\"/SerWise_war/Profile\"><img src=\"/SerWise_war/Assets/ProfilePic.jpg\" class=\"profile\"></a></td>\n" +
    "            </tr>\n" +
    "        </table>";

nav.innerHTML=innerText;