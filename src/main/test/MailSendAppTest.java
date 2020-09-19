import Input.Input;
import authorization.Authorization;
import emailManager.EmailHub;
import emailRepository.EmailRepository;
import operation.Operation;


import repository.StringRepository;
import timeStampRepository.TimeStampRepository;
import ui.UI;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MailSendAppTest {
    Input input = mock(Input.class);
    StringRepository stringRepository = mock(StringRepository.class);
    TimeStampRepository timeStampRepository = mock(TimeStampRepository.class);
    Operation operation = mock(Operation.class);
    Authorization authorization;
    EmailRepository emailRepository = mock(EmailRepository.class);
    EmailHub emailHub = mock(EmailHub.class);
    UI ui = mock(UI.class);

    @Test
    public void should_get_correct_output_for_a_valid_filepath() throws IOException {
        String path = "filesdir/logfile.txt";
        when(input.getInput()).thenReturn(path);

        ArrayList<String> readedData = new ArrayList<>();
        readedData.add("2020-09-06T17:24:09Z ERROR an exception occurred");
        readedData.add("2020-09-06T17:24:09Z ERROR Failed to read the text file");
        readedData.add("2020-09-06T17:27:19Z ERROR user password incorrect");
        when(stringRepository.FileRead(path)).thenReturn(readedData);

        when(timeStampRepository.GetTimeStamp()).thenReturn("");

        when(operation.getLastTimeStamp( readedData)).thenReturn("2020-09-06T17:27:19Z");

        when(operation.GetErrors(readedData, "")).thenReturn("ERROR an exception occurred\nERROR Failed to read the text file\nERROR user password incorrect");



        MailSendApp mailSendApp = new MailSendApp(input, stringRepository,  timeStampRepository, operation,
                emailRepository, authorization, emailHub, ui);

        mailSendApp.Execute();
        verify(stringRepository).FileRead(path);
        verify(timeStampRepository).GetTimeStamp();

    }

}