/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Owner;

import dao.BillDAO;
import dao.RoomDAO;
import model.Bill;
import model.Room;
import model.UsagePrice;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "EditRoomFee", urlPatterns = {"/editroomfee"})
public class EditRoomFee extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditRoomFee</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditRoomFee at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        BillDAO dao1 = new BillDAO();
        try {
            int id = Integer.parseInt(id_raw);
            Bill bill = dao1.getBillBybillID(id);
            HttpSession session = request.getSession();
            session.setAttribute("roomfeeID", id);
            RoomDAO dao = new RoomDAO();
            Room room = dao.getRoomDetailByID(id);
            UsagePrice price = dao1.getEWPrice();
            double eprice = price.getEprice();
            double wprice = price.getWprice();
            request.setAttribute("eprice", eprice);
            request.setAttribute("wprice", wprice);
            request.setAttribute("room", room);
            request.setAttribute("billDetail", bill);
            request.getRequestDispatcher("/Owner/editroomfee.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.err.println("Fail:" + e);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String service = request.getParameter("service");
        double serviceM = Double.parseDouble(service);
        HttpSession session = request.getSession();
        String roomID = null;
        Object roomIDObj = session.getAttribute("roomID");
        if (roomIDObj != null) {
            roomID = roomIDObj.toString();
        }
        int id = Integer.parseInt(roomID);
        RoomDAO dao1 = new RoomDAO();
        Room room = dao1.getRoomDetailByID(id);
        double roomfee = 0;
        //không fix cứng nữa
        switch (room.getRoomSize()) {
            case 1:
                roomfee = 3500000;
                break;
            case 2:
                roomfee = 3000000;
                break;
            default:
                break;
        }
        BillDAO dao = new BillDAO();
        Bill bill = dao.getBillBybillID(id);
        UsagePrice price = dao.getEWPrice();
        double eprice = price.getEprice();
        double wprice = price.getWprice();
        String water = request.getParameter("water");
        String electric = request.getParameter("electric");
        double elnum = Double.parseDouble(electric);
        double wnum = Double.parseDouble(water);
        double etotal = eprice * elnum;
        double wtotal = wprice * wnum;
        String other = request.getParameter("other");
        double otherM = Double.parseDouble(other);
        String pen = request.getParameter("penMoney");
        double penmoney = Double.parseDouble(pen);
//        String currentdeadline = bill.getDeadline();
        String deadlineStr = request.getParameter("deadline");
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        request.setCharacterEncoding("UTF-8");
        String updateMessage = "updateMessage";
        try {
            boolean success = dao.updateFeeById(id, serviceM, etotal, wtotal, roomfee, otherM, penmoney, deadlineStr, null);

            if (success) {
                request.setAttribute(updateMessage, "Add Successful");
                response.sendRedirect(request.getContextPath() + "/roomfee?id=" + roomID);
            } else {
                request.setAttribute(updateMessage, "Failed");
                response.sendRedirect(request.getContextPath() + "/editroomfee?id=" + roomID);

            }
        } catch (IOException ex) {
            response.sendRedirect(request.getContextPath() + "/editroomfee?id=" + roomID);

        }
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
