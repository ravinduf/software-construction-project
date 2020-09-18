package operation;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FilterOperationTest {

    @Test
    public void TestHasTimeStampAndHasError() {

        ArrayList<String> passedData = new ArrayList<String>();
        passedData.add("");
        Operation operation = new FilterOperation();
        operation.GetError();
    }

}