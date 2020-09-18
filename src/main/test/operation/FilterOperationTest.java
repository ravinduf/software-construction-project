package operation;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FilterOperationTest {

    @Test
    public void TestHasTimeStampAndHasError() {

        ArrayList<String> passedData = new ArrayList<String>();
        passedData.add("2020-09-06T17:23:09Z INFO application started");
        passedData.add("2020-09-06T17:24:09Z ERROR an exception occurred");
        passedData.add("2020-09-06T17:24:09Z ERROR Failed to read the text file");
        passedData.add("2020-09-06T17:25:20Z INFO user input captured");
        passedData.add("2020-09-06T17:26:09Z INFO application started");
        passedData.add("2020-09-06T17:27:19Z ERROR user password incorrect");
        passedData.add("2020-09-06T17:28:09Z ERROR can't file in that location");

        Operation operation = new FilterOperation();
        String data = operation.GetError(passedData, "2020-09-06T17:23:09Z");

        String AssumeOutPutString = "an exception occurred\n" +
                "Failed to read the text file\n" +
                "user password incorrect\n" +
                "can't file in that location\n";

        assertEquals(AssumeOutPutString, data);
    }
    @Test
    public void TestHasTimeStampAndNoError() {

        ArrayList<String> passedData = new ArrayList<String>();
        passedData.add("2020-09-06T17:23:09Z INFO application started");
//        passedData.add("2020-09-06T17:24:09Z ERROR an exception occurred");
//        passedData.add("2020-09-06T17:24:09Z ERROR Failed to read the text file");
        passedData.add("2020-09-06T17:25:20Z INFO user input captured");
        passedData.add("2020-09-06T17:26:09Z INFO application started");
//        passedData.add("2020-09-06T17:27:19Z ERROR user password incorrect");
//        passedData.add("2020-09-06T17:28:09Z ERROR can't file in that location");

        Operation operation = new FilterOperation();
        String data = operation.GetError(passedData, "2020-09-06T17:23:09Z");

        String AssumeOutPutString = "";

        assertEquals(AssumeOutPutString, data);
    }
    @Test
    public void TestNoStampAndHasError() {

        ArrayList<String> passedData = new ArrayList<String>();
        passedData.add("2020-09-06T17:23:09Z INFO application started");
        passedData.add("2020-09-06T17:24:09Z ERROR an exception occurred");
        passedData.add("2020-09-06T17:24:09Z ERROR Failed to read the text file");
        passedData.add("2020-09-06T17:25:20Z INFO user input captured");
        passedData.add("2020-09-06T17:26:09Z INFO application started");
        passedData.add("2020-09-06T17:27:19Z ERROR user password incorrect");
        passedData.add("2020-09-06T17:28:09Z ERROR can't file in that location");

        Operation operation = new FilterOperation();
        String data = operation.GetError(passedData, "");

        String AssumeOutPutString =  "an exception occurred\n" +
                "Failed to read the text file\n" +
                "user password incorrect\n" +
                "can't file in that location\n";

        assertEquals(AssumeOutPutString, data);
    }
    @Test
    public void TestNoStampAndNoError() {

        ArrayList<String> passedData = new ArrayList<String>();
        passedData.add("2020-09-06T17:23:09Z INFO application started");
//        passedData.add("2020-09-06T17:24:09Z ERROR an exception occurred");
//        passedData.add("2020-09-06T17:24:09Z ERROR Failed to read the text file");
        passedData.add("2020-09-06T17:25:20Z INFO user input captured");
        passedData.add("2020-09-06T17:26:09Z INFO application started");
//        passedData.add("2020-09-06T17:27:19Z ERROR user password incorrect");
//        passedData.add("2020-09-06T17:28:09Z ERROR can't file in that location");

        Operation operation = new FilterOperation();
        String data = operation.GetError(passedData, "");

        String AssumeOutPutString =  "";

        assertEquals(AssumeOutPutString, data);
    }
    @Test
    public void TestNoUpdateLogFile() {

        ArrayList<String> passedData = new ArrayList<String>();
        passedData.add("2020-09-06T17:23:09Z INFO application started");
        passedData.add("2020-09-06T17:24:09Z ERROR an exception occurred");
        passedData.add("2020-09-06T17:24:09Z ERROR Failed to read the text file");
        passedData.add("2020-09-06T17:25:20Z INFO user input captured");
        passedData.add("2020-09-06T17:26:09Z INFO application started");
        passedData.add("2020-09-06T17:27:19Z ERROR user password incorrect");
        passedData.add("2020-09-06T17:28:09Z ERROR can't file in that location");

        Operation operation = new FilterOperation();
        String data = operation.GetError(passedData, "2020-09-06T17:28:09Z");

        String AssumeOutPutString =  null;

        assertEquals(AssumeOutPutString, data);
    }
    @Test
    public void GetLastTimeStampHasReadedData() {
        ArrayList<String> readedData = new ArrayList<String>();
        readedData.add("2020-09-06T17:23:09Z INFO application started");
        readedData.add("2020-09-06T17:24:09Z ERROR an exception occurred");
        readedData.add("2020-09-06T17:24:09Z ERROR Failed to read the text file");
        readedData.add("2020-09-06T17:25:20Z INFO user input captured");
        readedData.add("2020-09-06T17:26:09Z INFO application started");
        readedData.add("2020-09-06T17:27:19Z ERROR user password incorrect");
        readedData.add("2020-09-06T17:28:09Z ERROR can't file in that location");

        Operation operation = new FilterOperation();
        String lastTimeStamp =  operation.getLastTimeStamp(readedData);
        assertEquals("2020-09-06T17:28:09Z", lastTimeStamp);
    }
    @Test
    public void GetLastTimeStampNoReadedData() {
        ArrayList<String> readedData = new ArrayList<String>();

        Operation operation = new FilterOperation();
        String lastTimeStamp =  operation.getLastTimeStamp(readedData);
        assertEquals(null, lastTimeStamp);
    }
}