package org.darrenchance.familychoremanager;

import entity.Chore;
import entity.Reward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "listChoresServlet", value = "/list-chores-servlet")
public class ListChoresServlet extends HttpServlet {
    private String message;
    private List<String> userNames = new ArrayList<>();

    public void init() {
        message = "Your logged in!";

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Database db = new Database();
        List<Reward> rewardList = db.listAllItems(Reward.class);

        request.setAttribute("rewardList", rewardList);

        RequestDispatcher rd = request.getRequestDispatcher("view-chores.jsp");
        rd.forward(request, response);
    }

    public void destroy() {
    }
}