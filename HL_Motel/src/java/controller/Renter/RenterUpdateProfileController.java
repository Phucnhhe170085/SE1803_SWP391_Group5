package controller.Renter;

import model.User;
import dao.RenterDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles updating of renter profiles.
 */
public class RenterUpdateProfileController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(RenterUpdateProfileController.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Method can be used for any common processing.
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jspuserID = request.getParameter("userID");
        RenterDAO dao = new RenterDAO();

        LOGGER.info("Received userID parameter: " + jspuserID);

        try {
            int userId = Integer.parseInt(jspuserID);
            User u = dao.getUserByID(userId);
            request.setAttribute("user", u);
            request.getRequestDispatcher("Renter/RenterUpdateProfile.jsp").forward(request, response);
            LOGGER.info("Forwarded request to RenterUpdateProfile.jsp");
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "NumberFormatException occurred: " + e.getMessage(), e);
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String jspuserID = request.getParameter("userID");
        RenterDAO dao = new RenterDAO();

        try {
            int userId = Integer.parseInt(jspuserID);

            String name = request.getParameter("userName");
            String gender = request.getParameter("userGender");
            String birth = request.getParameter("userBirth");
            String address = request.getParameter("userAddress");
            String phone = request.getParameter("userPhone");
            String avatar = "./Image/user/avatar1.jpg";

            // Validate inputs
            if (isNullOrWhitespace(name) || isNullOrWhitespace(gender) || isNullOrWhitespace(birth) || isNullOrWhitespace(address) || isNullOrWhitespace(phone)) {
                throw new IllegalArgumentException("All form fields are required.");
            }

            // Validate birth date format
            if (!isValidDate(birth)) {
                throw new IllegalArgumentException("Invalid date format. Please use YYYY-MM-DD.");
            }

            User uNew = new User(userId, name, gender, birth, address, phone, avatar);
            dao.updateUser(uNew);

            response.sendRedirect("renterupdate?userID=" + userId);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "NumberFormatException occurred: " + e.getMessage(), e);
            response.sendRedirect("error.jsp");
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, "Validation error: " + e.getMessage(), e);
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("Renter/RenterUpdateProfile.jsp").forward(request, response);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred: " + e.getMessage(), e);
        }
    }

    // Check if a string is null or consists only of whitespace characters
    private boolean isNullOrWhitespace(String input) {
        return input == null || input.trim().isEmpty();
    }

    // Validate date format and ensure date is not in the future
    private boolean isValidDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);  // Disable lenient parsing
            Date date = sdf.parse(dateStr);
            return !date.after(new Date());
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public String getServletInfo() {
        return "RenterUpdateProfileController handles updating of renter profiles";
    }
}
