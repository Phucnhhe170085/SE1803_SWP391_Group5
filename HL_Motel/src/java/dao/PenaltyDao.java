package dao;


import model.PenaltyList;
import model.Penalty;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import dao.DBContext;
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
public class PenaltyDao extends DBContext {

    public List<PenaltyList> getPenList() {
        List<PenaltyList> lpen = new ArrayList<>();
        String sql = "SELECT penID\n"
                + "      ,roomID\n"
                + "      ,description\n"
                + "      ,penDate\n"
                + "      ,r.ruleName\n"
                + "      ,penStatus\n"
                + "  FROM HL_Motel.dbo.penalty\n"
                + "  join [rule] r on r.ruleID = penalty.ruleID";

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

    public PenaltyList selectUpdateByPenID(String id) {
        String sql = "select penID, reportID,accuseID,roomID,description,penDate,penalty.ruleID,[rule].ruleName,penStatus\n"
                + "from penalty join [rule] \n"
                + "on penalty.ruleID = [rule].ruleID\n"
                + "where penID = ?";
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new PenaltyList(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getBoolean(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void addPenalty(String roomID, String description, String penDate, String ruleID) {
        String sql = "INSERT INTO HL_Motel.dbo.penalty (roomID, reportID, accuseID, description, penDate, ruleID, penStatus) VALUES (?,1,1, ?, ?, ?, 'false')";
        try (Connection conn = connection; PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, roomID);
            ps.setString(2, description);
            ps.setString(3, penDate);
            ps.setString(4, ruleID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePenalty(String penStatus, String penId) {
        String sql = "UPDATE HL_Motel.dbo.penalty SET  penStatus =? WHERE penID =?";
        try (Connection conn = connection; PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, penStatus);
            ps.setString(2, penId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deletePenalty(String penId) {
        String sql = "DELETE FROM HL_Motel.dbo.penalty WHERE penID = ?";
        try (Connection conn = connection; PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, penId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        PenaltyDao penaltyDao = new PenaltyDao();
        penaltyDao.selectUpdateByPenID("1");
        
        // Test getPenList
//        System.out.println("Testing getPenList()...");
//        List<PenaltyList> penalties = penaltyDao.getPenList();
//        for (PenaltyList p : penalties) {
//            System.out.println(p);
//        }

        // Test updatePenalty
//        System.out.println("Testing updatePenalty()...");
//        int penId = 64; // Get the last added penalty ID
//        penaltyDao.updatePenalty("Updated description", "2024-07-06", 1, true, penId);
//        System.out.println("Penalty updated.");
    }

}
