/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Account;

/**
 *
 * @author pc
 */
@WebServlet(name="Add", urlPatterns={"/add"})
public class Add extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<h1>Servlet Add at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
       
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String sEmail = request.getParameter("email");
        String sPassword = request.getParameter("password");
        String sRole = request.getParameter("role");
         try {
            // Kiểm tra email hợp lệ
            if (!EmailValidator.isValidEmail(sEmail)) {
                throw new Exception("Email is not exist.");
            }

            // Kiểm tra mật khẩu rỗng
            if (sPassword == null || sPassword.isEmpty()) {
                throw new Exception("Password is not empty.");
            }
            if(!isValidPassword(sPassword)){
                throw new Exception("Password must 8 characters, a number and a char");
            }

            // Kiểm tra vai trò rỗng
            if (sRole == null || sRole.isEmpty()) {
                throw new Exception("Role is not empty.");
            }

            // Nếu tất cả đều hợp lệ, chèn vào cơ sở dữ liệu
            DAO dao = new DAO();
            dao.insertAcc(sEmail, sPassword, sRole);
            response.sendRedirect("manage");

        } catch (Exception e) {
            // Xử lý lỗi và trả về thông báo cho người dùng
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h3>" + e.getMessage() + "</h3>");
            response.getWriter().println("<a href='Add.jsp'>Quay lại</a>");
            response.getWriter().println("</body></html>");
        }
       
      //  DAO dao = new DAO();
      //  dao.insertAcc(sEmail, sPassword, sRole);
       // response.sendRedirect("manage");
       // 
    }
    public boolean isValidEmail(String email) {
    String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
    return email.matches(regex);
    
}
    public class EmailValidator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
//    public class PasswordValidator {
//    public static boolean isValidPassword(String password) {
//        if (password == null || password.length() < 6) {
//            return false;
//        }
//        boolean hasUppercase = false;
//        for (char c : password.toCharArray()) {
//            if (Character.isUpperCase(c)) {
//                hasUppercase = true;
//                break;
//            }
//        }
//        return hasUppercase;
//    }
//}
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
            if (hasLetter && hasDigit) {return true;
            }
        }
        return false;
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
