import Input.CommandLineInput;
import Input.Input;
import authorization.Authorization;
import authorization.EmailAuthorization;
import emailManager.EmailHub;
import emailRepository.EmailRepository;
import emailRepository.MysqlEmailRepository;
import operation.FilterOperation;
import operation.Operation;
import repository.FileStringRepository;
import repository.StringRepository;
import timeStampRepository.FileTimeStampRepository;
import timeStampRepository.TimeStampRepository;
import ui.CommandLineUI;
import ui.UI;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Input input = new CommandLineInput();
        StringRepository stringRepository = new FileStringRepository();
        TimeStampRepository timeStampReposiroty = new FileTimeStampRepository();
        Operation operation = new FilterOperation();
        EmailRepository emailRepository = new MysqlEmailRepository();
        Authorization authorization = new EmailAuthorization();
        EmailHub emailHub = new EmailHub();
        UI ui = new CommandLineUI();
        MailSendApp mailSendApp = new MailSendApp(input, stringRepository,  timeStampReposiroty, operation,
                emailRepository, authorization, emailHub, ui);
        mailSendApp.Execute();

    }
}

