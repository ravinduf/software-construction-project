package operation;

import java.util.ArrayList;

public interface Operation {
    String GetError (ArrayList<String> readedDate, String time);
    String getLastTimeStamp (ArrayList<String> readedData);

}
