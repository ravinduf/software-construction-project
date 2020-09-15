package timeStampRepository;

import java.io.*;
import java.util.*;

public class FileTimeStampRepository {
    FileInputStream fileInputStream;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;

    public String GetTimeStamp() {
        String time = "";
        File file = new File("filesdir\\timeStamp.txt");

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        inputStreamReader = new InputStreamReader(fileInputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
    }

}
