package operation;

import java.util.ArrayList;

public interface Operation {
    String GetErrors (ArrayList<String> readedDate, String time);
    String getLastTimeStamp (ArrayList<String> readedData);

}
