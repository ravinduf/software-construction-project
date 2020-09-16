package repository;

import java.io.*;

import java.util.ArrayList;

public class FileStringRepository implements StringRepository {
    FileInputStream fileInputStream;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;
    //string path2 = "src\\resources\\log.txt";

    public ArrayList<String> FileRead(String path) throws IOException {
        String line;
        ArrayList<String> readedData = new ArrayList<String>();

        File file = new File(path);

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        inputStreamReader = new InputStreamReader(fileInputStream);
        bufferedReader = new BufferedReader(inputStreamReader);

        while ((line = bufferedReader.readLine())!= null) {
            readedData.add(line);
        }
        fileInputStream.close();
        inputStreamReader.close();
        bufferedReader.close();
        if (readedData != null ) {
            return readedData;
        }
        //if the log file is empty
        return null;
    }
}
