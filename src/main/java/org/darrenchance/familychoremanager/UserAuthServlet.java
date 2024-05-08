package org.darrenchance.familychoremanager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


@WebServlet(name = "userAuthServlet", value = "/user-auth-servlet")
public class UserAuthServlet extends HttpServlet {
    private String message;
    private List<String> userNames = new ArrayList<>();

    public void init() {
        message = "Your logged in!";
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        userNames.add("dchance12");
        userNames.add("mommy44");

        response.setContentType("text/html");
        // Getting passwoard name
        String userName = request.getParameter("userName");

        if(userNames.contains(userName)){
            PrintWriter writer = response.getWriter();
            writer.print("<h1>" + "Your logged in!" + "</h1>");
            writer.print("<p>" + "Welcome User: " + userName + "<p>");
            String pageNav = "<ul>\n" +
                    "    <li><a href=\"index.jsp\">Home</a></li>\n" +
                    "    <li><a href=\"list-chores-servlet\">List Chores</a></li>\n" +
                    "    <li><a href=\"contact.asp\">Contact</a></li>\n" +
                    "    <li><a href=\"about.asp\">About</a></li>\n" +
                    "</ul>";
            writer.print(pageNav);
        }else {
            PrintWriter writer = response.getWriter();
            writer.print("<h1>" + "Login Failed" + "</h1>");
            writer.print("<p>" + "Incorrect username/password" + "<p>");


        }

    }

    public void destroy() {
    }
}