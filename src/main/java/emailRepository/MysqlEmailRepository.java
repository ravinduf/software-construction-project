package emailRepository;

import java.sql.*;
import java.util.ArrayList;

public class MysqlEmailRepository implements EmailRepository {
    Connection con;
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/emails";
    String quary = "SELECT useremail FROM email";
    ArrayList<String> userData = new ArrayList<String>();

    public MysqlEmailRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/emails?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<String> ReadOperation(){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(quary);
            while (rs.next()) {
                userData.add(rs.getString(1));
            }
            return userData;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
