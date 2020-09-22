package operation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class FilterOperation implements Operation {

    public String GetErrors ( ArrayList<String> readedDate, String time ) {
        Date date = null;
        String errorMessage = "";

        String[] data = readedDate.get(readedDate.size()-1).split(" ");

        if( !data[0].equals(time)) {

            if( readedDate.size() > 0) {

                if ( time != "") {
                    if ( time != null ) {
                        date = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(time.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());
                    }
                }

                for ( String fileData: readedDate ) {

                    String[] fileDate = fileData.split(" ");
                    String parseString = fileDate[0];

                    Date temporyDate = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(parseString.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());

                    if ( date != null) {
                        long diff = date.getTime() - temporyDate.getTime();
                        if ( diff < 0 ) {
                            if(fileDate[1].equals("ERROR") ) {

                                String[] split_error_message = fileData.split(" ", 3);
                                errorMessage += split_error_message[2] + "\n";
                            }
                        }
                    } else {
                        if(fileDate[1].equals("ERROR") ) {
                            String[] split_error_message = fileData.split(" ", 3);
                            errorMessage += split_error_message[2] + "\n";
                        }
                    }

                }
                if ( errorMessage != null ) {
                    return errorMessage;
                }

                return null;
            } else {

                return null;
            }
        }
        else {

            return null;
        }
    }
    public String getLastTimeStamp (ArrayList<String> readedData ) {
        if ( readedData.size() > 0) {
            String[] date = readedData.get(readedData.size()-1).split(" ");
            return date[0];
        }
        else {
            return null;
        }
    }

    }
