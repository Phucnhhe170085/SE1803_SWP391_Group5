/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DBContext;
import Models.Item;
import Models.Room;
import Models.RoomItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoomDAO extends DBContext {
    
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Room"; 
        
        try (Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("roomID"));
                room.setRoomFloor(rs.getInt("roomFloor"));
                room.setRoomNumber(rs.getInt("roomNumber"));
                room.setRoomSize(rs.getInt("roomSize"));
                room.setRoomFee(rs.getFloat("roomFee"));
                
                room.setRoomImg(rs.getString("roomImg"));
                
                
                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rooms;
    }
    public List<RoomItem> getRoomDetails(String roomId){
        List<RoomItem> roomItems = new ArrayList<>();

        
        String sql = "select ri.itemID,i.itemName,i.itemImg,ri.quantity from roomItem ri join item i on ri.itemID = i.itemID where ri.roomID = ? ";
        
        
        try {java.sql.Connection conn = connection;
             PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomId);
            
             ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                RoomItem roomItem = new RoomItem();
                
                
                
                roomItem.setItemID(rs.getInt("itemID"));
                roomItem.setQuantity(rs.getInt("quantity"));
                roomItem.setItemName(rs.getString("itemName"));
                roomItem.setItemImg(rs.getString("itemImg"));
                
                
                roomItems.add(roomItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return roomItems;
    }
    public static void main(String[] args) {
       RoomDAO roomDetailDAO = new RoomDAO();
        List<RoomItem> rI = roomDetailDAO.getRoomDetails("1");
        
        
            for (RoomItem room : rI) {
                System.out.println(room);
                
            }
    }
}
