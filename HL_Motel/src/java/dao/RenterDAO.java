/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Renter;
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
    public List<Renter> getAllRenters() {
        List<Renter> renters = new ArrayList<>();
        String sql = "SELECT * FROM Renter"; 
        
        try (Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Renter rt = new Renter();
                rt.setRenterID(rs.getInt("renterID"));
                rt.setUserID(rs.getInt("userID"));
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
        List<Renter> renters = renterDAO.getAllRenters();
        
        
            for (Renter renter: renters) {
                System.out.println(renter);
            }
        
    }
}
