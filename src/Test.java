import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException {
        Connection con;
        Statement stmt;
        ResultSet rst;

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rst = stmt.executeQuery("select * from student.message");
        String string = rst.getString(1);
        String pas = rst.getString(2);
        System.out.println(string);
        System.out.println(pas);
    }

}
