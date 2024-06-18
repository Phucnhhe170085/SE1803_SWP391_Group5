/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Renter;
import Models.RenterList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RenterDAO extends DBContext {
    public List<RenterList> getRenters() {
        List<RenterList> renters = new ArrayList<>();
        String sql = "SELECT userName\n" +
                    "      ,userGender\n" +
                    "      ,r.roomID\n" +
                    "      ,r.renterStatus\n" +
                    "      ,r.renterHaveRoom\n" +
                    "      ,r.CGRScore\n" +
                    "	  ,r.balance\n" +
                    "  FROM [HL_Motel].[dbo].[user]\n" +
                    "  join renter r on [user].userID = r.userID"; 
        
        try (Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                RenterList rt = new RenterList();
                rt.setUserName(rs.getString("userName"));
                rt.setUserGender(rs.getString("userGender"));
                rt.setRoomID(rs.getInt("RoomID"));
                rt.setRenterStatus(rs.getBoolean("RenterStatus"));
                rt.setRenterHaveRoom(rs.getBoolean("RenterHaveRoom"));
                rt.setCGRScore(rs.getInt("CGRScore"));
                rt.setBalance(rs.getDouble("Balance"));
                
                
                renters.add(rt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return renters;
}
    public static void main(String[] args) {
        RenterDAO renterDAO = new RenterDAO();
        List<RenterList> renters = renterDAO.getRenters();
        
        
            for (RenterList renter: renters) {
                System.out.println(renter);
            }
        
    }
}
