/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.User;

/**
 *
 * @author pc
 */
public class DAOUser extends DBContext{
   public List<User> getUsers() {
        List<User> user = new ArrayList<>();

        try {
            // Truy vấn dữ liệu từ bảng Accounts
            String query = "SELECT * FROM [HL_Motel].[dbo].[user]";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
              int userID = rs.getInt("userID");
              String userName = rs.getString("userName");
              String userGender = rs.getString("userGender");
              Date userBirth = rs.getDate("userBirth");
              String userAddress = rs.getString("userAddress");
              String userPhone = rs.getString("userPhone");
              String userAvatar = rs.getString("userAvatar");
              

               
                User users = new User(userID, userName, userGender, userBirth, userAddress, userPhone, userAvatar);
                user.add(users);
            }

            rs.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return user;
    }
   
public static void main(String args[]){
        DAOUser dao = new DAOUser();
        List<User> user= dao.getUsers();
        for(User users : user){
            System.out.println(user);
        }
    }
}
