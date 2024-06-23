/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;



import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="RenterController", urlPatterns={"/rentercontroller"})
public class RenterController extends HttpServlet {

    private static final String RENTER_HOME = "renterhome";
    private static final String RENTER_PROFILE = "renterprofile";
    private static final String GUIDE_AND_RULE = "guideandrule";
    private static final String REQUEST = "request";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("service");

        if (service == null) {
            service = RENTER_HOME;
        }

        request.setAttribute("service", service);

        switch (service) {
            case RENTER_HOME:
                request.getRequestDispatcher("renterhome").forward(request, response);
                break;
            case RENTER_PROFILE:
                request.getRequestDispatcher("renterprofile").forward(request, response);
                break;
            case GUIDE_AND_RULE:
                request.getRequestDispatcher("guideandrule").forward(request, response);
                break;
            case REQUEST:
                request.getRequestDispatcher("request").forward(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Service not found: " + service);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "RenterController Servlet";
    }
}
