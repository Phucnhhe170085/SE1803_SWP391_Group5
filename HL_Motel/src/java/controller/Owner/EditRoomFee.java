package Controller.Owner;

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
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class EditRoomFee
 */
@WebServlet(name = "EditRoomFee", urlPatterns = {"/editroomfee"})
public class EditRoomFee extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        BillDAO dao1 = new BillDAO();
        try {
            int id = Integer.parseInt(id_raw);
            Bill bill = dao1.getBillBybillID(id);

            HttpSession session = request.getSession();
            session.setAttribute("billID", id);

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getSession().getAttribute("billID").toString());
        double service = Double.parseDouble(request.getParameter("service"));
        double electric = Double.parseDouble(request.getParameter("electric"));
        double water = Double.parseDouble(request.getParameter("water"));
        BigDecimal roomFee = new BigDecimal(request.getParameter("roomFee"));
        double other = Double.parseDouble(request.getParameter("other"));
        double penMoney = Double.parseDouble(request.getParameter("penMoney"));
        String deadline = request.getParameter("deadline");
        String payAt = request.getParameter("payAt");

        BillDAO billDAO = new BillDAO();

        boolean success = billDAO.updateFeeById(id, service, electric, water, roomFee, other, penMoney, deadline, payAt);

        String updateMessage = success ? "Update Successful" : "Update Failed";
        request.setAttribute("updateMessage", updateMessage);
        request.getRequestDispatcher("/Owner/editroomfee.jsp?id=" + id).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
