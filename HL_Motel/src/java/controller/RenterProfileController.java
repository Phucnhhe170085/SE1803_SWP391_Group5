package controller;

import models.User;
import models.Account;
import dao.RenterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 * Handles the RenterProfile functionality
 */
public class RenterProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RenterProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RenterProfileController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // For testing: Create and set a mock Account object with email and password
         HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        // Retrieve the account object from the session
        Account account = (Account) session.getAttribute("user");
        request.setAttribute("email", email);
        request.setAttribute("password", password);

        // Retrieve the account object from the session
        account = (Account) session.getAttribute("user");

        // Check if the account object exists in the session
        if (account != null) {
            // Extract email and password from the account object
            String userMail = (String) session.getAttribute("email");
            String userPassword = (String) session.getAttribute("password");

            // Use the email and password to fetch data
            RenterDAO dao = new RenterDAO();
            List<User> list = dao.getRenterDetailByAccountAndPassword(userMail, userPassword);
            request.setAttribute("ListRP", list);
            request.getRequestDispatcher("Renter/RenterProfile.jsp").forward(request, response);
        } else {
            // If account object is not found in the session, redirect the user to the login page
            response.sendRedirect("login.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
