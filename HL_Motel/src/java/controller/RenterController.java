package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name="RenterController", urlPatterns={"/rentercontroller"})
public class RenterController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(RenterController.class.getName());

    private static final String RENTER_HOME = "renterhome";
    private static final String RENTER_PROFILE = "renterprofile";
    private static final String GUIDE_AND_RULE = "guideandrule";
    private static final String REQUEST = "request";
    private static final String RENTER_UPDATE_PROFILE = "renterupdate";
    private static final String ERROR_PAGE = "error.jsp"; // Define your error page path

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("service");

        if (service == null) {
            service = RENTER_HOME;
        }

        LOGGER.info("Service requested: " + service);
        request.setAttribute("service", service);

        try {
            switch (service) {
                case RENTER_HOME:
                    request.getRequestDispatcher(RENTER_HOME).forward(request, response);
                    break;
                case RENTER_PROFILE:
                    request.getRequestDispatcher(RENTER_PROFILE).forward(request, response);
                    break;
                case GUIDE_AND_RULE:
                    request.getRequestDispatcher(GUIDE_AND_RULE).forward(request, response);
                    break;
                case REQUEST:
                    request.getRequestDispatcher(REQUEST).forward(request, response);
                    break;
                case RENTER_UPDATE_PROFILE:
                    request.getRequestDispatcher(RENTER_UPDATE_PROFILE).forward(request, response);
                    break;
                default:
                    LOGGER.warning("Service not found: " + service);
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Service not found: " + service);
                    break;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred while processing service: " + service, e);
            response.sendRedirect(ERROR_PAGE);
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
