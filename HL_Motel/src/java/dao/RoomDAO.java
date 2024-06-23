package dao;

import model.Room;
import model.Item;
import model.Room;
import model.RoomItem;
import java.lang.System.Logger;
import java.math.BigDecimal;
import java.sql.Connection;
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
                BigDecimal roomFee = rs.getBigDecimal("roomFee");
                String roomImg = rs.getString("roomImg");

                Room room = new Room(roomID, roomFloor, roomNumber, roomSize, roomImg, roomFee);
                rooms.add(room);
            }
        } catch (SQLException e) {

        }

        return rooms;
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
//ThienAnh Code

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Room";

        try (Connection conn = connection; PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("roomID"));
                room.setRoomFloor(rs.getInt("roomFloor"));
                room.setRoomNumber(rs.getInt("roomNumber"));
                room.setRoomSize(rs.getInt("roomSize"));
                room.setRoomFee(rs.getBigDecimal("roomFee"));

                room.setRoomImg(rs.getString("roomImg"));

                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rooms;
    }

    public List<RoomItem> getRoomDetails(String roomId) {
        List<RoomItem> roomItems = new ArrayList<>();

        String sql = "select ri.itemID,i.itemName,i.itemImg,ri.quantity from roomItem ri join item i on ri.itemID = i.itemID where ri.roomID = ? ";

        try {
            java.sql.Connection conn = connection;
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
        RoomDAO roomDAO = new RoomDAO();
//        User check = roomDAO.getOwnerProfileByID(15);
//        System.out.println(check.getUserBirth());
        int a = roomDAO.update(new User(15, "Nguyễn Văn Linh", "Female", "1991-12-05",
                "100 Hai Bà Trưng, Hoàn Kiếm, Hà Nội", "0987654321"));
        if (a > 0) {
            System.out.println("updated");
        } else {
            System.out.println("fail");
        }
    }
}
