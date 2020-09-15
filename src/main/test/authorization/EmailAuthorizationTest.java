package authorization;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmailAuthorizationTest {
    ArrayList<String> emails = new ArrayList<String>();

    @Test
    public void test(){
        EmailAuthorization emailAuthorization = new EmailAuthorization();
        emails.add("test@gamil.com");
        emails.add("test2@gamil.com");
        emails.add("test3@gamil.com");
        assertArrayEquals(null, new ArrayList[]{emailAuthorization.Validation(emails)});
    }
}