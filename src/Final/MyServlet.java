package Final;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyBean mb = new MyBean();
        HttpSession session = req.getSession(true);
        double sd = Double.parseDouble(req.getParameter("sd"));
        double xd = Double.parseDouble(req.getParameter("xd"));
        double high = Double.parseDouble(req.getParameter("high"));
        mb.setHigh(high);
        mb.setSd(sd);
        mb.setXd(xd);
        mb.qiuS();
        session.setAttribute("keyWord", mb);
//        resp.sendRedirect("show.jsp");//  重定向
        RequestDispatcher rd = req.getRequestDispatcher("show.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
