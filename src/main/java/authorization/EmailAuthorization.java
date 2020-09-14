package authorization;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;

public class EmailAuthorization implements Authorization{
    ArrayList<String> newEmails = new ArrayList<String>();

    public ArrayList<String> Validation(ArrayList<String> emails){
        EmailValidator validator = EmailValidator.getInstance();
        for ( String email : emails ) {
            if(validator.isValid(email)) {
                newEmails.add(email);
            }
        }
        return newEmails;
    }
}
