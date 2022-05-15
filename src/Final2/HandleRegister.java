package Final2;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HandleRegister extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        Register re;
        try {
            re = (Register) req.getAttribute("register");
            if (re == null) {
                re = new Register();
                req.setAttribute("register", re);
            }
        } catch (Exception e) {
            re = new Register();
            req.setAttribute("register", re);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e) {
        }

        Connection con;
        Statement stmt;
        ResultSet rst;
        try {
            String n = req.getParameter("name");
            //n = "随时";
            String p = req.getParameter("password");
            if (n == null || p == null) {
                resp.sendRedirect("index.jsp");
            }
            int a = Integer.parseInt(req.getParameter("age"));

            // 创建数据库连接
            String url = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String un = "root";         //MySql用户名
            String pa = "root";       //MySql密码
            con = DriverManager.getConnection(url, un, pa);
            // 根据数据库连接获取一个Statement对象
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.executeUpdate("insert into student.message values ('" + n + "', '" + p + "', " + a + ");");
            // 利用Statement对象执行数据库语句
            String sql = "select * from student.message";
            rst = stmt.executeQuery(sql);
            // 根据执行语句获得结果ResultSet对象

            // 获取ResultSetMetaData对象
            ResultSetMetaData md = rst.getMetaData();
            int col = md.getColumnCount(); // 求列数
            rst.last();
            int row = rst.getRow(); // 求行数

            Register reg = new Register(); // 创建实体类对象
            // 存储数据库处理结果信息
            String[] tabName = new String[col];
            for (int i = 0; i < col; i++) {
                tabName[i] = md.getColumnName(i + 1);
            }
            reg.setTableName(tabName);
            String[] name = new String[row];
            String[] password = new String[row];
            int[] age = new int[row];
            rst.beforeFirst();
            int i = 0;
            while (rst.next()) {
                name[i] = rst.getString(1);
                password[i] = rst.getString(2);
                age[i] = rst.getInt(3);
                i++;
            }
            reg.setName(name);
            reg.setPassword(password);
            reg.setAge(age);


            req.setAttribute("register", reg); // 将实体类存储到Request对象中
            // 转发
            req.getRequestDispatcher("ShowMessage.jsp").forward(req, resp);

            /*String name = req.getParameter("name");
            String password = req.getParameter("password");
            if (name == null || password == null) {
                resp.sendRedirect("index.jsp");
            }
            int age = Integer.parseInt(req.getParameter("age"));

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC", "root", "root");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.executeUpdate("insert into message values ('" + name + "', '" + password + "', " + age + ");");
            rst = stmt.executeQuery("select * from message");

            ResultSetMetaData md = rst.getMetaData();
            int col = md.getColumnCount();
            String[] sb = new String[col];
            for (int i = 0; i < col; i++) {
                sb[i] = md.getColumnName(i + 1);
            }
            re.setTableName(sb);

            rst.last();
            String[] n = new String[rst.getRow()];
            String[] ps = new String[rst.getRow()];
            int[] a = new int[rst.getRow()];

            rst.beforeFirst();
            int i = 0;
            while (rst.next()) {
                n[i] = rst.getString(1);
                ps[i] = rst.getString(2);
                a[i] = rst.getInt(3);
                i++;
            }
            re.setName(n);
            re.setPassword(ps);
            re.setAge(a);

            req.setAttribute("register", re);
            req.getRequestDispatcher("ShowMessage.jsp").forward(req, resp);*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
