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
import model.Penalty;

/**
 *
 * @author DAT
 */
@WebServlet(name = "ConfirmPenaltyController", urlPatterns = {"/confirmPenalty"})
public class ConfirmPenaltyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String raw_id = req.getParameter("id");
        int id = Integer.parseInt(raw_id);
        String raw_status = req.getParameter("status");
        int status = Integer.parseInt(raw_status);
        if(status == 0)status = -1;
        
        PenaltyDAO dbPenalty = new PenaltyDAO();
        Penalty penalty = dbPenalty.findById(id);
        penalty.setPenStatus(status);

        dbPenalty.updateStatus(penalty);
        resp.sendRedirect("penaltyHistory");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
