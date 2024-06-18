package dao;

import model.Room;
import java.lang.System.Logger;
import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.User;

public class RoomDAO extends DBContext {

    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM room";

        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int roomID = rs.getInt("roomID");
                int roomFloor = rs.getInt("roomFloor");
                int roomNumber = rs.getInt("roomNumber");
                int roomSize = rs.getInt("roomSize");
//                BigDecimal roomFee = rs.getBigDecimal("roomFee");
                String roomImg = rs.getString("roomImg");

                Room room = new Room(roomID, roomFloor, roomNumber, roomSize, roomImg, 0);
                rooms.add(room);
            }
        } catch (SQLException e) {

        }

        return rooms;
    }

    public Room findById(int id) {
        String query = "SELECT * FROM room where roomID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int roomID = rs.getInt("roomID");
                int roomFloor = rs.getInt("roomFloor");
                int roomNumber = rs.getInt("roomNumber");
                int roomSize = rs.getInt("roomSize");
                String roomImg = rs.getString("roomImg");

                Room room = new Room(roomID, roomFloor, roomNumber, roomSize, roomImg, 0);
                return room;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public User getOwnerProfileByID(int userID) {
        String query = "select u.userName, u.userGender, u.userBirth, u.userAddress, u.userPhone, a.userMail from account a join [user] u on u.userID = a.userID \n"
                + "  where a.userRole = 2 and u.userID = " + userID;
        User ownerProfile = null;

        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String userName = rs.getString("userName");
                String userGender = rs.getString("userGender");
                String userBirth = rs.getString("userBirth");
                String userAddress = rs.getString("userAddress");
                String userPhone = rs.getString("userPhone");
                String email = rs.getString("userMail");
                ownerProfile = new User(userName, userGender, userBirth, userAddress, userPhone, email);
            }
        } catch (SQLException e) {

        }

        return ownerProfile;
    }

    public int update(User ownerProfile) {
        int n = 0;
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [userName] = ?\n"
                + "      ,[userGender] = ?\n"
                + "      ,[userBirth] = ?\n"
                + "      ,[userAddress] = ?\n"
                + "      ,[userPhone] = ?      \n"
                + " WHERE userID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, ownerProfile.getUserName());
            pre.setString(2, ownerProfile.getUserGender());
            pre.setString(3, ownerProfile.getUserBirth());
            pre.setString(4, ownerProfile.getUserAddress());
            pre.setString(5, ownerProfile.getUserPhone());
            pre.setInt(6, ownerProfile.getUserID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }

        return n;
    }

    public static void main(String[] args) {
        RoomDAO roomDAO = new RoomDAO();
        System.out.println(roomDAO.getRooms().toString());
    }
}
