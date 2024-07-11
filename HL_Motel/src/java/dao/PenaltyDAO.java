/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GuideLine;
import model.Penalty;
import model.Room;
import model.Rule;

/**
 *
 * @author DAT
 */
public class PenaltyDAO extends DBContext {

    public ArrayList<Penalty> findAll() {
        ArrayList<Penalty> penaltys = new ArrayList<>();
        try {
            String sql = "select * from penalty";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                penaltys.add(toPenalty(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return penaltys;
    }

    public Penalty findById(int id) {
        try {
            String sql = "select * from penalty where penID = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return toPenalty(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insert(Penalty model) {
        try {
            String sql = "insert into penalty(roomID, description, penDate, ruleID, penStatus, evidenceImg) values (?,?,?,?,?,?)";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, model.getRoomID().getRoomID());
            ps.setString(2, model.getDescription());
            ps.setDate(3, model.getPenDate());
            ps.setInt(4, model.getRuleID().getRuleID());
            ps.setInt(5, model.getPenStatus());
            ps.setString(6, model.getEvidenceImg());
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int update(Penalty model) {
        try {
            String sql = "update penalty set roomID = ?, description = ?, penDate = ?, ruleID = ?, penStatus = ?, evidenceImg = ? where penID = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, model.getRoomID().getRoomID());
            ps.setString(2, model.getDescription());
            ps.setDate(3, model.getPenDate());
            ps.setInt(4, model.getRuleID().getRuleID());
            ps.setInt(5, model.getPenStatus());
            ps.setString(6, model.getEvidenceImg());
            ps.setInt(7, model.getPenID());
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int remove(int id) {
        try {
            String sql = "delete from penalty where penID = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int updateStatus(Penalty model) {
        try {
            String sql = "update penalty set penStatus = ? where penID = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, model.getPenStatus());
            ps.setInt(2, model.getPenID());
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    
    private Penalty toPenalty(ResultSet rs) throws SQLException {
        Penalty penalty = new Penalty();
        penalty.setPenID(rs.getInt("penID"));

        RoomDAO dbRoom = new RoomDAO();
        Room room = dbRoom.findById(rs.getInt("roomID"));
        penalty.setRoomID(room);

        penalty.setDescription(rs.getString("description"));
        penalty.setPenDate(rs.getDate("penDate"));

        RuleDAO dbRule = new RuleDAO();
        Rule rule = dbRule.findById(rs.getInt("ruleID"));
        penalty.setRuleID(rule);

        penalty.setPenStatus(rs.getInt("penStatus"));
        penalty.setEvidenceImg(rs.getString("evidenceImg"));

        return penalty;
    }
    
     public ArrayList<Penalty> findByRuleId(int ruleId) {
        ArrayList<Penalty> penaltys = new ArrayList<>();
        try {
            String sql = "select * from penalty where ruleID = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ruleId);
            rs = ps.executeQuery();

            while (rs.next()) {
                penaltys.add(toPenalty(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return penaltys;
    }
    
    public static void main(String[] args) {
        PenaltyDAO dbPenaltyDAO = new PenaltyDAO();
        System.out.println(dbPenaltyDAO.findAll().toString());
    }
}
