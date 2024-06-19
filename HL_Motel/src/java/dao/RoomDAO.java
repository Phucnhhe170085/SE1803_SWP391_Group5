package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import model.Rooms;
import java.lang.System.Logger;
import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Vector;
import model.RoomDetailSe;
import model.User;
import model.*;

public class RoomDAO extends DBContext {

    public List<Rooms> getRooms() {
        List<Rooms> rooms = new ArrayList<>();
        String query = "SELECT * FROM room";

        try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int roomID = rs.getInt("roomID");
                int roomFloor = rs.getInt("roomFloor");
                int roomNumber = rs.getInt("roomNumber");
                int roomSize = rs.getInt("roomSize");
                BigDecimal roomFee = rs.getBigDecimal("roomFee");
                String roomImg = rs.getString("roomImg");

                Rooms room = new Rooms(roomID, roomFloor, roomNumber, roomSize, roomImg, roomFee);
                rooms.add(room);
            }
        } catch (SQLException e) {

        }

        return rooms;
    }

    public List<String> getItemName() {
        List<String> itemNames = new ArrayList<>();
        String query = "SELECT itemName FROM item";

        try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String itemName = rs.getString("itemName");

                itemNames.add(itemName);
            }
        } catch (SQLException e) {

        }

        return itemNames;
    }

    public int getItemIDOrQuantityByItemName(String itemName, int flag, int roomID) {
        int raw = 0;
        if (flag == 0) {
            String query = "SELECT itemID FROM item WHERE itemName = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, itemName);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        raw = rs.getInt("itemID");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (flag == 1) {
            String query1 = "select quantity from roomItem ri\n"
                    + "  join item i \n"
                    + "  on ri.itemID = i.itemID\n"
                    + "  where itemName = ? and roomID = ?";
            try (PreparedStatement ps = conn.prepareStatement(query1)) {
                ps.setString(1, itemName);
                ps.setInt(2, roomID);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        raw = rs.getInt("quantity");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return raw;
    }

    public User getOwnerProfileByID(int userID) {
        String query = "select u.userName, u.userGender, u.userBirth, u.userAddress, u.userPhone, a.userMail, u.userAvatar from account a join [user] u on u.userID = a.userID \n"
                + "  where a.userRole = 2 and u.userID = " + userID;
        User ownerProfile = null;

        try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String userName = rs.getString("userName");
                String userGender = rs.getString("userGender");
                String userBirth = rs.getString("userBirth");
                String userAddress = rs.getString("userAddress");
                String userPhone = rs.getString("userPhone");
                String email = rs.getString("userMail");
                byte[] userAvatar = rs.getBytes("userAvatar");
                ownerProfile = new User(userName, userGender, userBirth, userAddress, userPhone, email, userAvatar);
            }
        } catch (SQLException e) {

        }

        return ownerProfile;
    }

    public int updateOwnerProfile(User ownerProfile) {
        int n = 0;
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [userName] = ?\n"
                + "      ,[userGender] = ?\n"
                + "      ,[userBirth] = ?\n"
                + "      ,[userAddress] = ?\n"
                + "      ,[userPhone] = ?      \n"
                + " WHERE userID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
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

    public int updateAvatar(User ownerProfile) {
        int n = 0;
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [userAvatar] = ?\n"
                + " WHERE userID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setBytes(1, ownerProfile.getUserAvatar());
            pre.setInt(2, ownerProfile.getUserID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }

        return n;
    }

    public byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096]; // Sử dụng một buffer có kích thước lớn hơn cho hiệu suất tốt hơn
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }

    public RoomDetailSe getRoomDetail(int roomid) {
        String query = "select ri.roomID, r.roomFloor, r.roomNumber, r.roomSize, r.roomFee, r.roomImg, i.itemName, i.itemImg, ri.quantity, ri.itemID\n"
                + "from roomItem ri\n"
                + "join room r\n"
                + "on ri.roomID = r.roomID\n"
                + "join item i\n"
                + "on ri.itemID = i.itemID\n"
                + "where r.roomID = ?";

        RoomDetailSe roomDetail = null;
        List<String> itemNames = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        List<Integer> itemIDs = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, roomid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (roomDetail == null) {
                        int roomID = rs.getInt("roomID");
                        int roomNumber = rs.getInt("roomNumber");
                        int roomFloor = rs.getInt("roomFloor");
                        int roomSize = rs.getInt("roomSize");
                        double roomFee = rs.getDouble("roomFee");
                        byte[] roomImg = rs.getBytes("roomImg");
                        byte[] itemImg = rs.getBytes("itemImg");
                        roomDetail = new RoomDetailSe(roomID, roomNumber, roomSize, roomFloor,
                                roomImg, null, itemImg, null, roomFee, null);
                    }

                    int quantity = rs.getInt("quantity");
                    quantities.add(quantity);

                    int itemID = rs.getInt("itemID");
                    itemIDs.add(itemID);

                    String itemName = rs.getString("itemName");
                    itemNames.add(itemName);
                }

                if (roomDetail != null) {
                    roomDetail.setItemName(itemNames.toArray(new String[0]));
                    roomDetail.setQuantity(quantities.stream().mapToInt(i -> i).toArray());
                    roomDetail.setItemID(itemIDs.stream().mapToInt(i -> i).toArray());
                }
                /* other
                int[] quantitiesArray = new int[quantities.size()];
                for (int i = 0; i < quantities.size(); i++) {
                    quantitiesArray[i] = quantities.get(i);
                }
                
                roomDetail.setQuantities(quantitiesArray);
                 */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomDetail;
    }

    public int deleteRoomItem(int roomID, int itemID) {
        String query = "DELETE FROM roomItem WHERE roomID = ? AND itemID = ?";
        int n = 0;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, roomID);
            ps.setInt(2, itemID);

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int addRoomItem(int roomID, int itemID, int quantity) {
        String query = "INSERT INTO [dbo].[roomItem]\n"
                + "           ([roomID]\n"
                + "           ,[itemID]\n"
                + "           ,[quantity])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int n = 0;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, roomID);
            ps.setInt(2, itemID);
            ps.setInt(3, quantity);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int updateItemQuantity(int roomID, int itemID, int quantity) {
        String query = "UPDATE roomItem SET quantity = ? WHERE roomID = ? AND itemID = ?";
        int n = 0;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, quantity);
            ps.setInt(2, roomID);
            ps.setInt(3, itemID);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int updateRoomDetail(int roomID, int roomNumber, double roomSize, double roomFee, byte[] roomImg) {
        String query = "UPDATE [dbo].[room]\n"
                + "   SET [roomNumber] = ?\n"
                + "      ,[roomSize] = ?\n"
                + "      ,[roomFee] = ?\n"
                + "      ,[roomImg] = ?\n"
                + " WHERE roomID = ?";
        int n = 0;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, roomNumber);
            ps.setDouble(2, roomSize);
            ps.setDouble(3, roomFee);
            ps.setBytes(4, roomImg);
            ps.setInt(5, roomID);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
        String test = "Abc";
        if (test.equals("abc")) {
            System.out.println("true");
        } else {
            System.out.println("fail");
        }
    }
}
