package controller.Renter;

import dao.RequestDAO;
import model.Account;
import model.ReqType;
import model.RequestList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "RequestController", urlPatterns = {"/request"})
public class RequestController extends HttpServlet {

    private RequestDAO requestDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        requestDAO = new RequestDAO();
    }

    private void populateRequestAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("user");

        if (account != null) {
            int userID = account.getUserID();
            List<ReqType> requestTypes = requestDAO.getAllReqType();
            List<RequestList> requests = requestDAO.getReqListByID(userID);
            request.setAttribute("requestTypes", requestTypes);
            request.setAttribute("requests", requests);
        } else {
            request.setAttribute("message", "User not logged in.");
        }
    }

    private void updateAbandonedRequests() {
        requestDAO.updateAbandonedRequests();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateAbandonedRequests();
        populateRequestAttributes(request);
        request.getRequestDispatcher("Renter/contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        int userID = (int) session.getAttribute("userID");

        // Update abandoned requests before processing
        updateAbandonedRequests();

        if (action != null) {
            if (action.equals("delete")) {
                int requestId = Integer.parseInt(request.getParameter("id"));
                RequestList requestDetails = requestDAO.getRequestByReqID(requestId);

                if (requestDetails != null && "Pending".equals(requestDetails.getResStatus())) {
                    boolean deleteSuccess = requestDAO.deleteRequest(requestId);

                    if (deleteSuccess) {
                        session.setAttribute("message", "Request deleted successfully.");
                    } else {
                        session.setAttribute("message", "Failed to delete request.");
                    }
                } else {
                    session.setAttribute("message", "Cannot delete request unless it is pending.");
                }

                // Redirect to avoid resubmission on refresh
                response.sendRedirect(request.getContextPath() + "/request");
                return;
            } else if (action.equals("edit")) {
                Account account = (Account) session.getAttribute("user");

                if (account == null) {
                    session.setAttribute("message", "User not logged in.");
                    response.sendRedirect(request.getContextPath() + "/Renter/contact.jsp");
                    return;
                }

                int renterID = account.getUserID();
                int requestType = Integer.parseInt(request.getParameter("requestType"));
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String createAt = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String resStatus = "Pending"; // Default value

                // Check if the request is pending before editing
                int requestId = Integer.parseInt(request.getParameter("id"));
                RequestList requestDetails = requestDAO.getRequestByReqID(requestId);

                if (requestDetails != null && "Pending".equals(requestDetails.getResStatus())) {
                    boolean updateSuccess = requestDAO.updateRequest(requestId, userID, requestType, title, description, createAt, resStatus);

                    if (updateSuccess) {
                        session.setAttribute("message", "Request updated successfully.");
                    } else {
                        session.setAttribute("message", "Failed to update request.");
                    }
                } else {
                    session.setAttribute("message", "Cannot edit request unless it is pending.");
                }

                // Redirect to avoid resubmission on refresh
                response.sendRedirect(request.getContextPath() + "/request");
                return;
            }
        } else {
            // Insert new request
            Account account = (Account) session.getAttribute("user");

            if (account == null) {
                session.setAttribute("message", "User not logged in.");
                response.sendRedirect(request.getContextPath() + "/Renter/contact.jsp");
                return;
            }

            int renterID = account.getUserID();
            int requestType = Integer.parseInt(request.getParameter("requestType"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String createAt = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String resStatus = "Pending"; // Default value

            // Check the number of pending requests
            int pendingRequestCount = requestDAO.countPendingRequests(userID);
            if (pendingRequestCount >= 3) {
                session.setAttribute("message", "Cannot have more than 3 pending requests.");
                response.sendRedirect(request.getContextPath() + "/request");
                return;
            }

            boolean insertSuccess = requestDAO.insertRequest(userID, requestType, title, description, createAt, resStatus);

            if (insertSuccess) {
                session.setAttribute("message", "Request sent to Owner.");
            } else {
                session.setAttribute("message", "Failed to insert request.");
            }

            // Redirect to avoid resubmission on refresh
            response.sendRedirect(request.getContextPath() + "/request");
            return;
        }
    }

    @Override
    public String getServletInfo() {
        return "Request Controller Servlet";
    }
}
