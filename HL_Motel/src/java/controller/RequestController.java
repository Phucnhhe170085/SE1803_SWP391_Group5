package controller;

import dao.RequestDAO;
import model.Account;
import model.ReqType;
import model.RequestList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;

@WebServlet(name = "RequestController", urlPatterns = {"/request"})
public class RequestController extends HttpServlet {

   private void populateRequestAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("user");
        
        if (account != null) {
            int userID = account.getUserID();
            RequestDAO dao = new RequestDAO();
            List<ReqType> requestTypes = dao.getAllReqType();
            List<RequestList> requests = dao.getReqListByID(userID);
            request.setAttribute("requestTypes", requestTypes);
            request.setAttribute("requests", requests);
        } else {
            request.setAttribute("message", "User not logged in.");
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RequestController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RequestController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        populateRequestAttributes(request);
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int renterID = Integer.parseInt(request.getParameter("renterID"));
            int requestType = Integer.parseInt(request.getParameter("requestType"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            Date createAt_raw = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String createAt = sdf.format(createAt_raw);
            String resStatus = request.getParameter("resStatus");

            RequestDAO dao = new RequestDAO();
            boolean success = dao.insertRequest(renterID, requestType, title, description, createAt, resStatus);

            if (success) {
                request.setAttribute("message", "Your request has been sent to the Owner.");
            } else {
                request.setAttribute("message", "There was a problem with your request. Please try again later.");
            }
            
            populateRequestAttributes(request);
            request.getRequestDispatcher("contact.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request");
        }
    }

    @Override
    public String getServletInfo() {
        return "Request Controller Servlet";
    }
}
