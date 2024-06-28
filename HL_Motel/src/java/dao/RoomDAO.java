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

        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
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

    public List<Rooms> pagingRoom(int index) {
        List<Rooms> rooms = new ArrayList<>();
        String query = "select * from room\n"
                + "order by roomID\n"
                + "OFFSET ? ROWS FETCH NEXT 6 ROWS only";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
            ResultSet rs = ps.executeQuery();
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

        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
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
            try (PreparedStatement ps = connection.prepareStatement(query)) {
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
            try (PreparedStatement ps = connection.prepareStatement(query1)) {
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

        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String userName = rs.getString("userName");
                String userGender = rs.getString("userGender");
                String userBirth = rs.getString("userBirth");
                String userAddress = rs.getString("userAddress");
                String userPhone = rs.getString("userPhone");
                String email = rs.getString("userMail");
                String userAvatar = rs.getString("userAvatar");
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

    public int updateAvatar(User ownerProfile) {
        int n = 0;
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [userAvatar] = ?\n"
                + " WHERE userID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, ownerProfile.getUserAvatar());
            pre.setInt(2, ownerProfile.getUserID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }

        return n;
    }

    public RoomDetailSe getRoomDetail(int roomid) {
        String query = "select r.roomID, r.roomFloor, r.roomNumber, r.roomSize, r.roomFee, r.roomImg, "
                + "i.itemName, i.itemImg, ri.quantity, ri.itemID "
                + "from room r "
                + "left join roomItem ri on r.roomID = ri.roomID "
                + "left join item i on ri.itemID = i.itemID "
                + "where r.roomID = ?";

        RoomDetailSe roomDetail = null;
        List<String> itemNames = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        List<Integer> itemIDs = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomid);
            try (ResultSet rs = ps.executeQuery()) {
                boolean roomDetailSet = false;
                while (rs.next()) {
                    if (!roomDetailSet) {
                        int roomID = rs.getInt("roomID");
                        int roomNumber = rs.getInt("roomNumber");
                        int roomFloor = rs.getInt("roomFloor");
                        int roomSize = rs.getInt("roomSize");
                        double roomFee = rs.getDouble("roomFee");
                        String roomImg = rs.getString("roomImg");
                        roomDetail = new RoomDetailSe(roomID, roomNumber, roomSize, roomFloor,
                                roomImg, null, null, null, roomFee, null);
                        roomDetailSet = true;
                    }

                    int itemID = rs.getInt("itemID");
                    if (!rs.wasNull()) {
                        String itemName = rs.getString("itemName");
                        itemNames.add(itemName);

                        int quantity = rs.getInt("quantity");
                        quantities.add(quantity);

                        itemIDs.add(itemID);
                    }
                }

                if (roomDetail != null) {
                    roomDetail.setItemName(itemNames.toArray(new String[0]));
                    roomDetail.setQuantity(quantities.stream().mapToInt(i -> i).toArray());
                    roomDetail.setItemID(itemIDs.stream().mapToInt(i -> i).toArray());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomDetail;
    }

    public int deleteRoomItem(int roomID, int itemID) {
        String query = "DELETE FROM roomItem WHERE roomID = ? AND itemID = ?";
        int n = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
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
        try (PreparedStatement ps = connection.prepareStatement(query)) {
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
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, quantity);
            ps.setInt(2, roomID);
            ps.setInt(3, itemID);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int updateRoomDetail(int roomID, int roomNumber, double roomSize, double roomFee, String roomImg) {
        String query = "UPDATE [dbo].[room]\n"
                + "   SET [roomNumber] = ?\n"
                + "      ,[roomSize] = ?\n"
                + "      ,[roomFee] = ?\n"
                + "      ,[roomImg] = ?\n"
                + " WHERE roomID = ?";
        int n = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomNumber);
            ps.setDouble(2, roomSize);
            ps.setDouble(3, roomFee);
            ps.setString(4, roomImg);
            ps.setInt(5, roomID);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int getTotalRoom() {
        String query = "select count(*) from room";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
        List<Rooms> pagingRoom = dao.pagingRoom(3);
        for (Rooms rooms : pagingRoom) {
            System.out.println(rooms.getRoomNumber());
        }
    }
}
















