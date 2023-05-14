package com.CS01.SerWise.Services.Process;

public class sendMessage {
    public static String sendMessage(String text, String contactNum){
        String APIreq = "https://app.notify.lk/api/v1/send?user_id=24917&api_key=JC8gO5svXwpzjuR6WYp0&sender_id=NotifyDEMO&to="+contactNum+"&message="+text;
        return APIreq;
    }
}
