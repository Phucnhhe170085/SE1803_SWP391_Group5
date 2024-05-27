package controller;

import models.News;
import models.Account;
import models.User;
import dao.DAORenter;
import dao.RenterDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RenterHomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // For testing: Create and set a mock Account object with email and password
        Account account = new Account();
        account.setUserMail("maingoctu@gmail.com");
        account.setUserPassword("pass1234");
        session.setAttribute("user", account);
        session.setAttribute("email", "maingoctu@gmail.com");
        session.setAttribute("password", "pass1234");

        // Retrieve the account object from the session
        account = (Account) session.getAttribute("user");

        // Check if the account object exists in the session
        if (account != null) {
            // Extract email and password from the account object
            String userMail = (String) session.getAttribute("email");
            String userPassword = (String) session.getAttribute("password");

            // Now you can use the email and password to fetch data or perform any other actions
            // Example:
            DAORenter dao1 = new DAORenter();
            List<News> listN = dao1.getAllNews();
            request.setAttribute("ListN", listN);

            RenterDAO dao = new RenterDAO();
            List<User> list = dao.getRenterDetailByAccountAndPassword(userMail, userPassword);
            request.setAttribute("ListRP", list);
            request.getRequestDispatcher("Renter/RenterHome.jsp").forward(request, response);
        } else {
            // If account object is not found in the session, handle the situation accordingly
            // For example, redirect the user to the login page
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // This method might be used for handling form submissions in the future
        // For now, you can leave it empty
    }
}
