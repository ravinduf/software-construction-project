import input.Input;
import authorization.Authorization;
import authorization.EmailAuthorization;
import emailManager.EmailHub;
import emailRepository.EmailRepository;
import operation.Operation;
import repository.StringRepository;
import timeStampRepository.TimeStampReposiroty;
import ui.UI;

import java.io.IOException;
import java.util.ArrayList;

public class MailSendApp {
    private final Input input;
    private final StringRepository stringRepository;
    private final TimeStampReposiroty timeStampReposiroty;
    private final Operation operation;
    private final EmailRepository emailRepository;
    private final Authorization authorization;
    private final EmailHub emailHub;
    private final UI ui;

    public MailSendApp(Input input, StringRepository stringRepository, TimeStampReposiroty timeStampReposiroty,
                       Operation operation, EmailRepository emailRepository,
                       Authorization authorization, EmailHub emailHub, UI ui) {
        this.input = input;
        this.stringRepository = stringRepository;
        this.timeStampReposiroty = timeStampReposiroty;
        this.operation = operation;
        this.emailRepository = emailRepository;
        this.authorization = authorization;
        this.emailHub = emailHub;
        this.ui = ui;
    }
    public void Execute() {
        ArrayList<String> readedData = null;
        String timeStamp ;
        String errorMessage ;
        String LastTimeStamp ;

        ui.printData("Enter the file path :")
        String filePath = input.getInput;
        try {
            readedData = stringRepository.FileRead(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (readedData == null) {
            ui.printData("LOG file is EMPTY");
            return;
        }
        timeStamp = timeStampReposiroty.GetTimeStamp();
//        System.out.println(timeStamp);
        errorMessage = operation.GetErrors( readedData, timeStamp);

        ui.printData("Error messages :");
        ui.printData(errorMessage);

        if (errorMessage == null) {
            ui.printData("No ERRORS in file");
            return;
        }
        LastTimeStamp = operation1.getLastTimeStamp( readedData );
        if(LastTimeStamp == null) {
            ui.printData("ERROR occurs");
            return;
        }

        timeStampRepository.SetTimeStamp(LastTimeStamp);

        ArrayList<String> emails = emailRepository.ReadOperation();

        if(emails == null) {
            ui.printData("NO Emails in DataBase");
            return;
        }
        ArrayList<String> newEmails =  authorization.Validation(emails);
        if(newEmails == null) {
            ui.printData("NO Valid Emails in DataBase");
            return;
        }
        ArrayList<String> returnMessage = emailHub.EmailSendRepository(newEmails, errorMessage);
        if (readedData == null) {
            ui.printData("Can not send emails, There is error in that read log file or something");
        }
        else {
            ui.printData("EMAILS send");
        }
    }
}
