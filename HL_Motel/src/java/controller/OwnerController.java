package controller;

import dao.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import model.*;

@WebServlet(name = "OwnerController", urlPatterns = {"/OwnerController"})
public class OwnerController extends HttpServlet {

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
        String service = request.getParameter("service");
        HttpSession session = request.getSession();
        if (service == null) {
            service = "OwnerHome";
        }
        request.setAttribute("service", service);

        if (service.equals("OwnerHome")) {
            OwnerHome(request, response);
        } else if (service.equals("listRoom")) {
            listRoom(request, response);
        } else if (service.equals("ownerProfile")) {
            getOwnerProfile(request, response, 0);
        } else if (service.equals("editOwnerProfile")) {
            getOwnerProfile(request, response, 1);
        } else if (service.equals("updateOwnerProfile")) {
            updateOwnerProfile(request, response);
        }
    }

    private void OwnerHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("owner/OwnerHome.jsp").forward(request, response);
    }

    private void listRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        List<Rooms> rooms = dao.getRooms();

        for (int i = 0; i < 10; i++) {
            System.out.println(rooms.get(i).getRoomSize());
        }
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("owner/rooms.jsp").forward(request, response);
    }

    private void getOwnerProfile(HttpServletRequest request, HttpServletResponse response, int flag) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        User ownerProfile = dao.getOwnerProfileByID(15);
        request.setAttribute("ownerProfile", ownerProfile);
        if (flag == 0) {
            request.getRequestDispatcher("owner/ownerProfile.jsp").forward(request, response);
        } else if (flag == 1) {
            request.getRequestDispatcher("owner/formOwnerProfile.jsp").forward(request, response);
        }
    }
    
    private void updateOwnerProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        
        String fullName = request.getParameter("fullName");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        
        int update = dao.update(new User(15, fullName, gender, dob, address, phone));
        
        response.sendRedirect("OwnerController?service=ownerProfile");
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
        processRequest(request, response);
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
