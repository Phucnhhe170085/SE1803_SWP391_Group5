/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.Owner;

import dao.NewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.News;

/**
 *
 * @author pc
 */
@WebServlet(name="displayNewController", urlPatterns={"/displayNews"})
public class displayNewController extends HttpServlet {
   
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
        NewDAO newsDAO = new NewDAO(); // Assuming NewsDAO handles database operations
        List<News> newsList = newsDAO.getNewsList(); // Fetch news list from DAO
       SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss.S");
       SimpleDateFormat sds = new SimpleDateFormat("dd-MM-yyyy ");
        for (News news : newsList) {
            Date date = null;
            String formattedDate = news.getCreateAt();
        
        try {
            // Chuyển chuỗi gốc thành đối tượng Date
         date = inputFormat.parse(formattedDate);
            // Chuyển đối tượng Date thành chuỗi theo định dạng mong muốn
            formattedDate = sds.format(date);
            news.setCreateAt(formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
       
        request.setAttribute("newsList", newsList); // Set newsList attribute for JSP

        request.getRequestDispatcher("Owner/DisplayNews.jsp").forward(request, response); // Forward to JSP for display
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
         processRequest(request, response);
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
        processRequest(request, response);
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