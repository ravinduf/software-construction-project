package authorization;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmailAuthorizationTest {
    @Test
    public void TestAllEmailCorrect(){
        ArrayList<String> emailTest = new ArrayList<String>();
        Authorization authorization = new EmailAuthorization();
        emailTest.add("test01@gmail.com");
        emailTest.add("test02@gmail.com");
        emailTest.add("test03@gmail.com");
        emailTest.add("test04@gmail.com");
        ArrayList<String> email = authorization.Validation(emailTest);

        assertArrayEquals(emailTest.toArray(), email.toArray());

    }
    @Test
    public void TestNullEmail(){

        ArrayList<String> emailTest2 = new ArrayList<String>();
        Authorization authorization = new EmailAuthorization();
        ArrayList<String> email = authorization.Validation(emailTest2);

        assertArrayEquals(emailTest2.toArray(), email.toArray());

    }
    @Test
    public void TestInvalidEmail(){
        ArrayList<String> emailTest = new ArrayList<String>();
        emailTest.add("testgmail.com");
        emailTest.add("test@gmail");
        emailTest.add("test@gmailcom");

        Authorization authorization = new EmailAuthorization();
        ArrayList<String> email = authorization.Validation(emailTest);

        ArrayList<String> emailTest2 = new ArrayList<String>();

        assertArrayEquals(emailTest2.toArray(), email.toArray());

    }
    @Test
    public void TestInvalidEmailAndValidEmail(){
        ArrayList<String> emailTest = new ArrayList<String>();
        emailTest.add("testgmail.com");
        emailTest.add("test@gmail");
        emailTest.add("test1@gmail.com");
        emailTest.add("test@gmailcom");
        emailTest.add("test2@gmail.com");

        Authorization authorization = new EmailAuthorization();
        ArrayList<String> email = authorization.Validation(emailTest);

        ArrayList<String> emailTest2 = new ArrayList<String>();
        emailTest2.add("test1@gmail.com");
        emailTest2.add("test2@gmail.com");

        assertArrayEquals(emailTest2.toArray(), email.toArray());

    }


}