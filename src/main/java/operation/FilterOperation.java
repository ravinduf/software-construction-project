package operation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class FilterOperation implements Operation {

    public String GetError ( ArrayList<String> readedDate, String time ) {
        Date date = null;
        String errorMessage = "";
//      String sDate6 = "2020-09-06T17:29:20Z";

//      Date date = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(sDate6.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());
        String[] data = readedDate.get(readedDate.size()-1).split(" ");

        if( !data[0].equals(time)) {

            if( readedDate.size() > 0) {

                if ( time != "") {
                    date = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(time.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());
                }
//        System.out.println(date);

                for ( String fileData: readedDate ) {

                    String[] fileDate = fileData.split(" ");
                    String parseString = fileDate[0];

                    Date temporyDate = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(parseString.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());

                    if ( date != null ) {
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
//                System.out.println("No ERRORS found");
                return null;
            } else {
//                System.out.println("LOG File is EMPTY");
                return null;
            }
        }
        else {
//            System.out.println("Log File is not Updated");
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
