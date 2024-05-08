package org.darrenchance.familychoremanager;

import entity.Chore;
import entity.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Servlet to serve dashboard for the family chore manager application. The main purpose of this class is to serve up
 * all the data associated with the dashboard from the server and forward it to a page for display
 */
@WebServlet(name = "dashboardServletV2", value = "/dashboard-v2-servlet")

public class DashboardServletV2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database db = new Database();
        // Setting chore
        List distinctRoomIds = Collections.singletonList(db.listAllItems(Chore.class, Chore.DISTINCT_ROOM)).get(0);
        ArrayList<Integer> roomIds = (ArrayList<Integer>) distinctRoomIds;
        List<Chore> chores = db.listAllItems(Chore.class);

        List<Room> roomObjs = new ArrayList<>();
        for(Integer i: roomIds){
            roomObjs.add(db.getRoomById(i));
        }
        req.setAttribute("roomObjs", roomObjs);
        req.setAttribute("rooms", roomIds);
        req.setAttribute("chores", chores);
        // Forward data to the jsp page for display and use
        RequestDispatcher rd = req.getRequestDispatcher("dashboard-v2.jsp");
        rd.forward(req,resp);
    }
}
