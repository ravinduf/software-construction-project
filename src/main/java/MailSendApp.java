import Input.Input;
import authorization.Authorization;
import authorization.EmailAuthorization;
import emailManager.EmailHub;
import emailRepository.EmailRepository;
import operation.Operation;
import repository.StringRepository;
import timeStampRepository.TimeStampRepository;
import ui.UI;

public class MailSendApp {
    private final Input input;
    private final StringRepository stringRepository;
    private final TimeStampRepository timeStampRepository;
    private final Operation operation;
    private final Authorization authorization;
    private final EmailRepository emailRepository;
    private final EmailHub emailHub;
    private final UI ui;

    public MailSendApp(Input input, StringRepository stringRepository, TimeStampRepository timeStampRepository,
                   Operation operation, EmailRepository emailRepository,
                   EmailHub emailHub, UI ui) {
        this.input = input;
        this.stringRepository = stringRepository;
        this.timeStampRepository = timeStampRepository;
        this.operation = operation;
        this.emailRepository = emailRepository;
        this.authorization = authorization;
        this.emailHub = emailHub;
        this.ui = ui;
    }


}
