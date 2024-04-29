package org.darrenchance.familychoremanager;

import entity.Chore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "createChoreServlet", value = "/create-chore-servlet")
public class CreateChoreServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Database db = new Database();

        int choreTypeId = Integer.parseInt(req.getParameter("chore-type"));
        int choreRoomId = Integer.parseInt(req.getParameter("room"));
        int userId = Integer.parseInt(req.getParameter("username"));

        Chore newChore = new Chore();
        newChore.setChoreTypeId(choreTypeId);
        newChore.setRoomId(choreRoomId);
        newChore.setUserId(userId);

        db.add(newChore);

        PrintWriter printWriter = resp.getWriter();
        printWriter.print("Chore id: "+choreTypeId);

    }

    //    public static void main(String[] args) {
//        Database db = new Database();
//
////        ChoreType newChoreType = new ChoreType();
////        newChoreType.setChoreName("Random chore");
////        newChoreType.setChoreTypeDescription("This is a random chore.");
////        db.add(newChoreType);
//        Chore newChore = new Chore();
//        newChore.setChoreTypeId(1004);
//        newChore.setUserId(16);
//        newChore.setRoomId(1);
//        //newChore.setStatus("incomplete");
//
//        // need to sumbit a choreId
//        // need to submit a userId
//        // need to submit a roomId
//
//        db.add(newChore);
//
//    }
}
