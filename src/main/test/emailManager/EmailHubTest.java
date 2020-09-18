package emailManager;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmailHubTest {
    ArrayList<String> emails = new ArrayList<String>();
    ArrayList<String> result = new ArrayList<String>();
    
    @Test
    public void TestEmailSend(){
        emails.add("test1@gmail.com");
        emails.add("test2@gmail.com");
        emails.add("test3@gmail.com");

        EmailHub emailHub = new EmailHub();
        result = emailHub.EmailSendRepository(emails, "Error message in occured");

        assertArrayEquals(emails.toArray(), result.toArray());
    }

}