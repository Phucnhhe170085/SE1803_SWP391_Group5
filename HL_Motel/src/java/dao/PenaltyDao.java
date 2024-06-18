package DAO;

import Models.PenaltyList;
import Models.Penalty;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Connection;
import java.sql.SQLException;
import DAO.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class PenaltyDao extends DBContext{
    public List<PenaltyList> getPenList() {
        List<PenaltyList> lpen = new ArrayList<>();
        String sql = "SELECT penID\n" +
                        "      ,roomID\n" +
                        "      ,description\n" +
                        "      ,penDate\n" +
                        "      ,r.ruleName\n" +
                        "      ,penStatus\n" +
                        "  FROM HL_Motel.dbo.penalty\n" +
                        "  join [rule] r on r.ruleID = penalty.ruleID";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PenaltyList PenaltyList = new PenaltyList();

                PenaltyList.setPenId(rs.getInt("penId"));
                PenaltyList.setRoomId(rs.getInt("roomId"));
                PenaltyList.setDescription(rs.getString("description"));
                PenaltyList.setPenDate(rs.getDate("penDate"));
                PenaltyList.setRuleName(rs.getString("ruleName"));
                PenaltyList.setPenStatus(rs.getBoolean("penStatus"));
                lpen.add(PenaltyList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lpen;
    }
    public void addPenalty(PenaltyList penalty) {
        String sql = "INSERT INTO HL_Motel.dbo.penalty (roomID, description, penDate, ruleID, penStatus) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, penalty.getRoomId());
            ps.setString(2, penalty.getDescription());
            ps.setDate(3, new java.sql.Date(penalty.getPenDate().getTime()));
            ps.setInt(4, penalty.getRuleId());
            ps.setBoolean(5, penalty.isPenStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePenalty(PenaltyList penalty) {
        String sql = "UPDATE HL_Motel.dbo.penalty SET roomID = ?, description = ?, penDate = ?, ruleID = ?, penStatus = ? WHERE penID = ?";
        try (Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, penalty.getRoomId());
            ps.setString(2, penalty.getDescription());
            ps.setDate(3, new java.sql.Date(penalty.getPenDate().getTime()));
            ps.setInt(4, penalty.getRuleId());
            ps.setBoolean(5, penalty.isPenStatus());
            ps.setInt(6, penalty.getPenId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePenalty(int penId) {
        String sql = "DELETE FROM HL_Motel.dbo.penalty WHERE penID = ?";
        try (Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, penId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        PenaltyDao PenaltyDao = new PenaltyDao();
        List<PenaltyList> rI = PenaltyDao.getPenList();

        for (PenaltyList room : rI) {
            System.out.println(room);

        }
    }
    
}
