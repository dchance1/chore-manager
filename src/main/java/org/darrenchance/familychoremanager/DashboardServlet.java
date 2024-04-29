package org.darrenchance.familychoremanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to serve dashboard for the family chore manager application. The main purpose of this class is to serve up
 * all the data associated with the dashboard from the server and foward it to a page for display
 */
@WebServlet(name = "dashboardServlet", value = "/dashboard-servlet")

public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO Get a list of all chores
        //  - Must be sorted by room
        //  - Must

        System.out.println("This is the DashboardServlet");

        //TODO forward to the jsp page for display to user
    }
}
