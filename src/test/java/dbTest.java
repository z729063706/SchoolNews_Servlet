import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
import com.util.c3p0Util;

public class dbTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = c3p0Util.getConnection();
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
