package org.darrenchance.familychoremanager;

import entity.Chore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet creates/adds a chore to the database.
 */
@WebServlet(name = "createChoreServlet", value = "/create-chore-servlet")
public class CreateChoreServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choreAdded = "";
        resp.setContentType("text/html");
        Database db = new Database();
        // Getting parameters required for adding a chore to database
        int choreTypeId = Integer.parseInt(req.getParameter("chore-type"));
        int choreRoomId = Integer.parseInt(req.getParameter("room"));
        int userId = Integer.parseInt(req.getParameter("username"));
        // Creating chore object that will be used to persist data to database using hibernate framework
        Chore newChore = new Chore();
        newChore.setChoreTypeId(choreTypeId);
        newChore.setRoomId(choreRoomId);
        newChore.setUserId(userId);
        // Adding chore to database
        db.add(newChore);
        // Forwarding to results.jsp page with message of success
        choreAdded = "Chore added successfully";
        req.setAttribute("successMessage",choreAdded);
        RequestDispatcher rd = req.getRequestDispatcher("results.jsp");
        rd.forward(req, resp);
    }
}
