/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
@WebServlet(name = "Add", urlPatterns = {"/addAccount"})
public class Add extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add at " + request.getContextPath() + "</h1>");
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
        String sEmail = request.getParameter("email");
        String sPassword = request.getParameter("password");
        String sRole = request.getParameter("role");


        response.setContentType("text/html;charset=UTF-8");

        try {
           
            if (!isValidEmail(sEmail)) {
                request.setAttribute("errorMessage1", "Invalid email format.");
                request.getRequestDispatcher("Admin/Tables.jsp").forward(request, response);
                return;
            }
            
            int role = Integer.parseInt(sRole);
            if (role < 1 || role > 3) {
                request.setAttribute("errorMessage1", "Role must be between 1 and 3.");
                request.getRequestDispatcher("Admin/Tables.jsp").forward(request, response);
                return;
            }

            // Kiểm tra mật khẩu hợp lệ
            if (!isValidPassword(sPassword)) {
                request.setAttribute("errorMessage1", "Password must contain at least 8 characters, including uppercase letters and numbers.");
                request.getRequestDispatcher("Admin/Tables.jsp").forward(request, response);
                return;
            }

            DAO dao = new DAO();
           
            if (dao.isEmailExist(sEmail)) {
                request.setAttribute("errorMessage1", "Email already exists.");
                request.getRequestDispatcher("Admin/Tables.jsp").forward(request, response);
                return;
            }

            
            dao.insertAcc(sEmail, sPassword, role);    
            response.sendRedirect("manage");

        } catch (NumberFormatException e) {
            
            e.printStackTrace();
            request.setAttribute("errorMessage1", "Role must be a number.");
            request.getRequestDispatcher("Admin/Tables.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
           
            e.printStackTrace();
            request.setAttribute("errorMessage1", e.getMessage());
            request.getRequestDispatcher("Admin/Tables.jsp").forward(request, response);

        } catch (Exception e) {
           
            e.printStackTrace();
            request.setAttribute("errorMessage1", "An error occurred while adding the account. Please try again.");
            request.getRequestDispatcher("Admin/Tables.jsp").forward(request, response);
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
            processRequest(request, response);

    }

    public boolean isValidEmail(String email) {
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        return email.matches(regex);

    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasLetter && hasDigit) {
                return true;
            }
        }
        return false;
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
