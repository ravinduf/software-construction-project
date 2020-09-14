package emailRepository;

import java.sql.Connection;
import java.util.ArrayList;

public class MysqlEmailRepository implements EmailRepository {
    Connection con;
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/emails";
    String quary = "SELECT useremail FROM email";
    ArrayList<String> userData = new ArrayList<String>();
    
    public ArrayList<String> ReadOperation(){
        return null;
    }
}
