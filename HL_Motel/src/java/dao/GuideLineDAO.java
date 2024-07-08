/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
import model.GuideLine;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAT
 */
public class GuideLineDAO extends DBContext {

    public ArrayList<GuideLine> findAll() {
        ArrayList<GuideLine> guideLines = new ArrayList<>();
        try {
            String sql = "select * from guideline";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                guideLines.add(toGuideLine(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuideLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(guideLines.size());
        return guideLines;
    }

    public GuideLine findById(int id) {
        try {
            String sql = "select * from guideline where guideID = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return toGuideLine(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuideLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insert(GuideLine model) {
        try {
            String sql = "insert into guideline(guideName, img) values (?,?)";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setString(1, model.getGuideName());
            ps.setString(2, model.getImg());
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(GuideLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int update(GuideLine model) {
        try {
            String sql = "update guideline set guideName = ?, img = ? where guideID = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setString(1, model.getGuideName());
            ps.setString(2, model.getImg());
            ps.setInt(3, model.getGuideID());
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(GuideLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int remove(int id) {
        try {
            String sql = "delete from guideline where guideID = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(GuideLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    private GuideLine toGuideLine(ResultSet rs) throws SQLException {
        GuideLine guideLine = new GuideLine();
        guideLine.setGuideID(rs.getInt("guideID"));
        guideLine.setGuideName(rs.getString("guideName"));
        guideLine.setImg(rs.getString("img"));
        return guideLine;
    }
}