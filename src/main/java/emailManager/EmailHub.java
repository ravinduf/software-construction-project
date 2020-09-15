package emailManager;


import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;

public class EmailHub {
    public ArrayList<String> EmailSendRepository(ArrayList<String> emails, String errorMessage) {
        if ( errorMessage != null ) {
            for (String email: emails ) {
                try {
                    SendMail mailSend = new SendMail();
                    JsonNode jsonNode = mailSend.sendSimpleMessage(email, errorMessage);
                    System.out.println(jsonNode.toString());
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            }
            return emails;
        }
        return null;
    }
}
