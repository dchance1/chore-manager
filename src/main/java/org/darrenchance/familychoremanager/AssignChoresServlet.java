package org.darrenchance.familychoremanager;

import entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "assignChoresServlet", value = "/assign-chores-servlet")
public class AssignChoresServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Your logged in!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Database db = new Database();
        // Getting lists of all chore types, users and rooms
        List<ChoreType> choreList = db.listAllItems(ChoreType.class);
        List<Room> roomList = db.listAllItems(Room.class);
        List<User> userList = db.listAllItems(User.class);
        // Setting attributes to so the lists can be accessed in .jsp
        request.setAttribute("choreList", choreList);
        request.setAttribute("roomList", roomList);
        request.setAttribute("userList", userList);
        // Forwarding the information to the page for use
        RequestDispatcher rd = request.getRequestDispatcher("assign-chore.jsp");
        rd.forward(request, response);
    }

    public void destroy() {
    }
}