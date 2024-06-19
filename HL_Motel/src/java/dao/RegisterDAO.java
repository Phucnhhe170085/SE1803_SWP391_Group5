package dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import model.Rooms;
import java.lang.System.Logger;
import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.Account;
import model.User;

public class RegisterDAO extends DBContext {

    public int validatePhoneAndEmail(User ownerProfile) {
        int n = 0;
        String sql = "select * \n"
                + "from [user] u join account a\n"
                + "on u.userID = a.userID\n"
                + "where userPhone = ? or a.userMail = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ownerProfile.getUserPhone());
            pre.setString(2, ownerProfile.getEmail());

            ResultSet resultSet = pre.executeQuery();
            if (resultSet.next()) {
                n = 1;
            }
        } catch (SQLException ex) {

        }

        return n;
    }

    public int addAccount(Account account) {
        int userID = -1;
        String sql = "INSERT INTO [dbo].[account]\n"
                + "           ([userMail]\n"
                + "           ,[userPassword]\n"
                + "           ,[userRole])\n"
                + "     VALUES (?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, account.getUserMail());
            pre.setString(2, account.getUserPassword());
            pre.setInt(3, account.getUserRole());
            int rows = pre.executeUpdate();

            if (rows > 0) {
                try (ResultSet rs = pre.getGeneratedKeys()) {
                    if (rs.next()) {
                        userID = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {

        }
        return userID;
    }

    public int addUser(User user, int userID) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[user]\n"
                + "           ([userID]\n"
                + "           ,[userName]\n"
                + "           ,[userGender]\n"
                + "           ,[userBirth]\n"
                + "           ,[userAddress]\n"
                + "           ,[userPhone]\n"
                + "           ,[userAvatar])\n"
                + "     VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, userID);
            pre.setString(2, user.getUserName());
            pre.setString(3, user.getUserGender());
            pre.setString(4, user.getUserBirth());
            pre.setString(5, user.getUserAddress());
            pre.setString(6, user.getUserPhone());
            pre.setBytes(7, user.getUserAvatar());
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }
        return n;
    }

    public static byte[] convertImageToByteArray(String imagePath) {
        File imageFile = new File(imagePath);
        try (FileInputStream fis = new FileInputStream(imageFile); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Đọc dữ liệu từ file ảnh và ghi vào ByteArrayOutputStream
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            // Chuyển đổi ByteArrayOutputStream thành byte[]
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        RegisterDAO roomDAO = new RegisterDAO();
        int b = roomDAO.addAccount(new Account("hehehe1@gmail.com", "1234567891abC@", 1));

        String imagePath = "images/firefly.jpg";

        // Chuyển đổi file ảnh sang byte[]
        byte[] imageBytes = convertImageToByteArray(imagePath);

        // Kiểm tra kết quả
        if (imageBytes != null) {
            System.out.println("Image converted to byte array successfully.");
            System.out.println("Byte array length: " + imageBytes.length);
        } else {
            System.out.println("Failed to convert image to byte array.");
        }
    }
}
