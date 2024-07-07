/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.RenterPenChart;
import Models.RoomItem;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DAO.DBContext;
import Models.RulePenChart;
import Models.SeUserProfile;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class SecurityDAO extends DBContext {

    public List<RenterPenChart> getTopPenRenter() {
        List<RenterPenChart> pen = new ArrayList<>();
        String sql = "select top 5 p.roomID, SUM(r.penMoney) as penMoney from penalty p join [rule] r on p.ruleID = r.ruleID group by p.roomID order by penMoney DESC";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RenterPenChart RenterPenChart = new RenterPenChart();

                RenterPenChart.setRoomID(rs.getInt("roomID"));
                RenterPenChart.setPenMoney(rs.getFloat("penMoney"));
                pen.add(RenterPenChart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pen;
    }

    public List<RulePenChart> getTopPenRule() {
        List<RulePenChart> pen = new ArrayList<>();
        String sql = "SELECT TOP 3 r.ruleName, COUNT(p.ruleID) AS Number\n"
                + "FROM penalty p\n"
                + "JOIN [rule] r ON p.ruleID = r.ruleID\n"
                + "GROUP BY p.ruleID, r.ruleName\n"
                + "ORDER BY Number DESC;";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RulePenChart RulePenChart = new RulePenChart();

                RulePenChart.setRuleName(rs.getString("ruleName"));
                RulePenChart.setNumber(rs.getInt("Number"));
                pen.add(RulePenChart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pen;
    }
    
    public List<SeUserProfile> showProfile(String seID) {
    List<SeUserProfile> show = new ArrayList<>();
    String sql = "SELECT \n" +
                    "  i.seID,\n" +
                    "  i.userID,\n" +
                    "  i.seID,\n" +
                    "  j.userName,\n" +
                    "  j.userGender,\n" +
                    "  j.userBirth,\n" +
                    "  j.userAddress,\n" +
                    "  j.userPhone,\n" +
                    "  j.userAvatar,\n" +
                    "  k.userMail,\n" +
                    "  i.sShift,\n" +
                    "  i.seStatus\n" +
                    "FROM \n" +
                    "  HL_Motel.dbo.security i\n" +
                    "  JOIN HL_Motel.dbo.[user] j ON i.userID = j.userID\n" +
                    "  join HL_Motel.dbo.[account] k on i.userID = k.userID\n" +
                    "  where i.seID = ?;";

    try {
        java.sql.Connection conn = connection;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, seID); // set the userID parameter
        
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            SeUserProfile profile = new SeUserProfile();
            
            profile.setSeID(rs.getInt("seID"));
            profile.setUserName(rs.getString("userName"));
            profile.setUserGender(rs.getString("userGender"));
            profile.setUserBirth(rs.getDate("userBirth"));
            profile.setUserAddress(rs.getString("userAddress"));
            profile.setUserPhone(rs.getString("userPhone"));
            profile.setUserAvatar(rs.getString("userAvatar"));
            profile.setUserMail(rs.getString("userMail"));
            profile.setxShift(rs.getInt("sShift"));
            profile.setSeStatus(rs.getBoolean("seStatus"));

            show.add(profile);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return show;
    }
    public SeUserProfile selectUpdateByAccount(String name,String pass){
        
        return null;
    }
    
    public boolean editUserProfile(SeUserProfile profile) {
    String sqlUser = "UPDATE HL_Motel.dbo.[user] SET userName =?, userGender =?, userBirth =?, userAddress =?, userPhone =?, userAvatar =? WHERE userID = (SELECT userID FROM HL_Motel.dbo.security WHERE seID =?)";
    String sqlAccount = "UPDATE HL_Motel.dbo.[account] SET userMail =? WHERE userID = (SELECT userID FROM HL_Motel.dbo.security WHERE seID =?)";

    try {
        java.sql.Connection conn = connection;
        conn.setAutoCommit(false);

        PreparedStatement psUser = conn.prepareStatement(sqlUser);
        psUser.setString(1, profile.getUserName());
        psUser.setString(2, profile.getUserGender());
        psUser.setDate(3, profile.getUserBirth());
        psUser.setString(4, profile.getUserAddress());
        psUser.setString(5, profile.getUserPhone());
        psUser.setString(6, profile.getUserAvatar());
        psUser.setInt(7, profile.getSeID());

        int rowsAffectedUser = psUser.executeUpdate();

        PreparedStatement psAccount = conn.prepareStatement(sqlAccount);
        psAccount.setString(1, profile.getUserMail());
        psAccount.setInt(2, profile.getSeID());

        int rowsAffectedAccount = psAccount.executeUpdate();

        conn.commit();

        return rowsAffectedUser > 0 && rowsAffectedAccount > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    public static void main(String[] args) {
    SecurityDAO securityDAO = new SecurityDAO();

    // Create a new SeUserProfile object to update
    SeUserProfile profile = new SeUserProfile();
    profile.setSeID(1); // assume seID 2 exists in the database
    profile.setUserID(1); // assume userID 1 exists in the database
    profile.setUserName("New Name");
    profile.setUserGender("Male");
    profile.setUserBirth(java.sql.Date.valueOf("1990-01-01"));
    profile.setUserAddress("New Address");
    profile.setUserPhone("123-456-7890");
    
    profile.setUserMail("new_email@example.com");
    profile.setxShift(0);
    profile.setSeStatus(true);

    boolean updated = securityDAO.editUserProfile(profile);
    if (updated) {
        System.out.println("User profile updated successfully!");
    } else {
        System.out.println("Failed to update user profile.");
    }
    }
}
