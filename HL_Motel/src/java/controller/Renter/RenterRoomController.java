/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Renter;

import dao.RenterDAO;
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
import model.RoomDetailSe;
import model.Rooms;

/**
 *
 * @author quocp
 */
@WebServlet(name = "RenterListRoom", urlPatterns = {"/RenterRoomController"})
public class RenterRoomController extends HttpServlet {

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

        if (service.equals("listRoom")) {
            listRoom(request, response);
        } else if (service.equals("roomDetail")) {
            roomDetail(request, response);
        } else if (service.equals("rentRoom")) {
            rentRoom(request, response, 0);
        } else if (service.equals("cancelRoom")) {
            rentRoom(request, response, 1);
        } else if (service.equals("confirmRentRoom")) {
            confirmRentRoom(request, response);
        }
    }

    private void listRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        int index = Integer.parseInt(request.getParameter("index"));
        if (index == 0) {
            index = 1;
        }
        List<Rooms> rooms = dao.pagingRoom(index);
        List<Rooms> allRooms = dao.getRooms();
        int totalRoom = dao.getTotalRoom();
        int totalPage = totalRoom / 6;
        if (totalPage % 6 != 0) {
            totalPage++;
        }
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("index", index);
        request.setAttribute("rooms", rooms);
        request.setAttribute("allRooms", allRooms);

        request.getRequestDispatcher("Renter/listRoom.jsp").forward(request, response);
    }

    private void roomDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        HttpSession session = request.getSession();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        RoomDetailSe roomDetail = dao.getRoomDetail(roomID);
        request.setAttribute("roomDetail", roomDetail);
        session.setAttribute("roomID", roomID);
        request.getRequestDispatcher("Renter/roomDetail.jsp").forward(request, response);
    }

    private void rentRoom(HttpServletRequest request, HttpServletResponse response, int flag) throws ServletException, IOException {
        RenterDAO dao = new RenterDAO();
        RoomDAO daoRoom = new RoomDAO();
        int roomID = Integer.parseInt(request.getParameter("roomID"));

        if (flag == 0) {
            boolean lockRoom = dao.lockRoom(roomID);
            RoomDetailSe roomDetail = daoRoom.getRoomDetail(roomID);
            request.setAttribute("roomDetail", roomDetail);
            request.setAttribute("roomID", roomID);
            request.getRequestDispatcher("Renter/confirmRentRoom.jsp").forward(request, response);
        } else if (flag == 1) {
            boolean unlockRoom = dao.unlockRoom(roomID);
            request.getRequestDispatcher("RenterRoomController?service=listRoom&index=1").forward(request, response);
        }
    }

    private void confirmRentRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        HttpSession session = request.getSession();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        RoomDetailSe roomDetail = dao.getRoomDetail(roomID);
        request.setAttribute("roomDetail", roomDetail);
        session.setAttribute("roomID", roomID);
        request.getRequestDispatcher("Renter/confirmRentRoom.jsp").forward(request, response);
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
