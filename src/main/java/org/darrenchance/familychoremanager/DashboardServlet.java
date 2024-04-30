package org.darrenchance.familychoremanager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet to serve dashboard for the family chore manager application. The main purpose of this class is to serve up
 * all the data associated with the dashboard from the server and forward it to a page for display
 */
@WebServlet(name = "dashboardServlet", value = "/dashboard-servlet")

public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database db = new Database();
        // Setting chore
        List<Object[]> chores = db.getAllChores();
        req.setAttribute("chores", db.getAllChores());
        // Forward data to the jsp page for display and use
        RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
        rd.forward(req,resp);
    }
}
