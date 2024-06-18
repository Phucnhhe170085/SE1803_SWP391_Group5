/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PenaltyDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author DAT
 */
@WebServlet(name = "DeletePenaltyController", urlPatterns = {"/deletePenalty"})
public class DeletePenaltyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        PenaltyDAO dbPenalty = new PenaltyDAO();
        dbPenalty.remove(id);
        resp.sendRedirect("penaltys");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
