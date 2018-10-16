package us.mattgreen.comics.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "PlaceOrderController")
public class PlaceOrderController extends HttpServlet {

    // handle the Post requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // handle the get requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // An enumeration of request parameters
        Enumeration parameters = request.getParameterNames();

        String orderLine = "";
        String parmName = "";

        // while parameters enumerator has more elements
        while (parameters.hasMoreElements()) {

            parmName = (String) parameters.nextElement();
            // string array of parmValues from the request, passing the parmName
            String[] parmValues = request.getParameterValues(parmName);

            if (parmValues.length == 1) {
                String parmVal = parmValues[0];
                if (parmVal.length() == 0) {
                    orderLine = "Empty Cart";
                } else {
                    orderLine = parmVal;
                }
            } else {
                for (int i = 0; i < parmValues.length; i++) {
                    orderLine += parmValues[i] + ",";
                }
                orderLine = orderLine.substring(0,orderLine.length()-2);
            }
        }
        //creating the cookie
        Cookie cookie = new Cookie(parmName,orderLine);
        cookie.setMaxAge(60 * 60);
        // add cookie to the response
        response.addCookie(cookie);

        response.setStatus(response.SC_MOVED_TEMPORARILY);

        //setting location to first.jsp
        response.setHeader("Location", "test.jsp");

    }
}