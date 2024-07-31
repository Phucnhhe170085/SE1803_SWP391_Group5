package controller.Owner;

import dao.BillDAO;
import dao.RoomDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Room;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(name = "ImportController", urlPatterns = {"/importRenter"})
@MultipartConfig

public class ImportController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Part filePart = request.getPart("file"); // Retrieve the file part
            try (InputStream fileContent = filePart.getInputStream();
                 Workbook workbook = new XSSFWorkbook(fileContent)) {

                Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

                BillDAO billDAO = new BillDAO();
                RoomDAO roomDAO = new RoomDAO();

                for (Row row : sheet) {
                    if (row.getRowNum() == 0) {
                        // Skip the header row
                        continue;
                    }

                    try {
                        String renterName = getCellValueAsString(row.getCell(0));
                        int roomNumber = (int) row.getCell(1).getNumericCellValue();
                        String roomFloor = getCellValueAsString(row.getCell(2));
                        double serviceFee = row.getCell(3).getNumericCellValue();
                        double electricNumber = row.getCell(4).getNumericCellValue();
                        double waterNumber = row.getCell(5).getNumericCellValue();
                        double otherFee = row.getCell(6).getNumericCellValue();
                        double penFee = row.getCell(7).getNumericCellValue();

                        Room room = roomDAO.getRoomDetailByNumber(roomNumber);
                        if (room != null) {
                            BigDecimal roomFee = room.getRoomFee();
                            billDAO.insertBillFromExcel(roomNumber, serviceFee, electricNumber, waterNumber, roomFee, otherFee, penFee);
                            out.println("<h1>Bill successfully inserted for room number " + roomNumber + ".</h1>");
                        } else {
                            out.println("<h1>Room not found for room number " + roomNumber + ".</h1>");
                        }
                    } catch (Exception e) {
                        out.println("<h1>Error processing row " + row.getRowNum() + ": " + e.getMessage() + "</h1>");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while importing data. Please try again.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private String getCellValueAsString(org.apache.poi.ss.usermodel.Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for importing renter data from Excel file";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ImportController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImportController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

