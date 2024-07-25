

package controller.Renter;

import dao.RenterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.RentDetail;
import model.Renter;

/**
 *
 * @author quocp
 */
@WebServlet(name="RenterRoomDetail", urlPatterns={"/RenterRoomDetail"})
public class RenterRoomDetail extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         Get the roomID parameter from the request
        HttpSession session = request.getSession();
        RenterDAO dao = new RenterDAO();
        
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
            
        List<Renter> basicDetailRenter = dao.getRenterDetail(email, password);
        int userID = 0;
        for (Renter renter : basicDetailRenter) {
            userID = renter.getUserID();
        }

        // Call the rentDetail method
        List<RentDetail> rentDetails = dao.rentDetail(userID);

        // Set the rent details as a request attribute
        request.setAttribute("rentDetails", rentDetails);

        // Forward the request to the JSP page
        request.getRequestDispatcher("Renter/RenterRoomDetail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}