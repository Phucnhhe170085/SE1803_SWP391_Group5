package dao;

import models.Account;
import models.Renter;
import models.Room;
import models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data Access Object for Renter-related operations.
 * 
 * Author: creep
 */
public class RenterDAO extends MyDAO {

    // Retrieve user details by account and password
    public List<User> getRenterDetailByAccountAndPassword(String accountInput, String passwordInput) {
        List<User> list = new ArrayList<>();
        String sql = "SELECT DISTINCT "
                + "    u.userID, u.userName, u.userGender, u.userBirth, u.userAddress, u.userPhone, u.userAvatar, \n"
                + "    r.renterID, r.roomID, r.renterStatus, r.renterHaveRoom, r.CGRScore, r.balance, \n"
                + "    a.userMail, a.userPassword, \n"
                + "    rm.roomFloor, rm.roomNumber \n"
                + "FROM \n"
                + "    \"user\" u \n"
                + "JOIN \n"
                + "    renter r ON u.userID = r.userID \n"
                + "JOIN \n"
                + "    account a ON u.userID = a.userID \n"
                + "LEFT JOIN \n"
                + "    room rm ON r.roomID = rm.roomID \n"
                + "WHERE \n"
                + "    a.userMail = ? AND a.userPassword = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, accountInput);
            ps.setString(2, passwordInput);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt(1);
                String userName = rs.getString(2);
                String userGender = rs.getString(3);
                String userBirth = rs.getString(4);
                String userAddress = rs.getString(5);
                String userPhone = rs.getString(6);
                String userAvatar = rs.getString(7);
                int renterID = rs.getInt(8);
                int roomID = rs.getInt(9);
                boolean renterStatus = rs.getBoolean(10);
                boolean renterHaveRoom = rs.getBoolean(11);
                int CGRScore = rs.getInt(12);
                double balance = rs.getDouble(13);
                String userMail = rs.getString(14);
                String userPassword = rs.getString(15);
                int roomFloor = rs.getInt(16);
                String roomNumber = rs.getString(17);

                Account account = new Account(userID, userMail, userPassword, 1);
                Renter renter = new Renter(renterID, userID, roomID, renterStatus, renterHaveRoom, CGRScore, balance);
                Room room = new Room(roomID, roomFloor, Integer.parseInt(roomNumber), 0, 0, null, 0, null, null);
                User user = new User(userID, userName, userGender, userBirth, userAddress, userPhone, userAvatar, account, renter, room);
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return list;
    }

    // Change password for a user
    public boolean changePassword(String accountInput, String oldPassword, String newPassword) {
        String sql = "UPDATE account SET userPassword = ? WHERE userMail = ? AND userPassword = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, accountInput);
            ps.setString(3, oldPassword);

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
            return false;
        }
    }

    // Retrieve password by account
    public String getPasswordByAccount(String accountInput) {
        String password = null;
        String sql = "SELECT userPassword FROM Account WHERE userMail = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, accountInput);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                password = rs.getString("userPassword");
            }
        } catch (SQLException e) {
            Logger.getLogger(RenterDAO.class.getName()).log(Level.SEVERE, "Failed to get password", e);
        }
        return password;
    }

    // Update password for a user
    public boolean updatePassword(String accountInput, String newPassword) {
        String sql = "UPDATE Account SET userPassword = ? WHERE userMail = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, accountInput);

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            Logger.getLogger(RenterDAO.class.getName()).log(Level.SEVERE, "Failed to update password", e);
            return false;
        }
    }

    // Update user information
    public boolean updateUser(int id, String gender, String address, String phone, String birth, String name) {
        String sql = "UPDATE [dbo].[user] "
                + "SET userName = ?, userGender = ?, userBirth = ?, userAddress = ?, userPhone = ? "
                + "WHERE userID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, birth);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setInt(6, id);

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RenterDAO.class.getName()).log(Level.SEVERE, "Failed to update user", ex);
            return false;
        }
    }

    // Retrieve user by ID
    public User getUserByID(int userID) {
        String sql = "SELECT * FROM [dbo].[user] WHERE userID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("userID"),
                        rs.getString("userName"),
                        rs.getString("userGender"),
                        rs.getString("userBirth"),
                        rs.getString("userAddress"),
                        rs.getString("userPhone"),
                        rs.getString("userAvatar")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(RenterDAO.class.getName()).log(Level.SEVERE, "Failed to get user by ID", e);
            return null;
        }
    }

    // Update user using User object
    public void updateUser(User u) {
        String sql = "UPDATE [dbo].[user] "
                + "SET userName = ?, userGender = ?, userBirth = ?, userAddress = ?, userPhone = ?, userAvatar = ? "
                + "WHERE userID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUserName());
            st.setString(2, u.getUserGender());
            st.setString(3, u.getUserBirth());
            st.setString(4, u.getUserAddress());
            st.setString(5, u.getUserPhone());
            st.setString(6, u.getUserAvatar());
            st.setInt(7, u.getUserID());

            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RenterDAO.class.getName()).log(Level.SEVERE, "Failed to update user", e);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        RenterDAO dao = new RenterDAO();
        int userID = 1; // Assuming you want to retrieve the user with ID 1
        User user = dao.getUserByID(userID);
        if (user != null) {
            System.out.println("User ID: " + user.getUserID());
            System.out.println("User Name: " + user.getUserName());
            // Print other user information as needed
        } else {
            System.out.println("User with ID " + userID + " not found.");
        }
    }
}
