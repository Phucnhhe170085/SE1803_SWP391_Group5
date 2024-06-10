/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author pc
 */
public class DAO extends DBContext{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
     public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();

        try {
            // Truy vấn dữ liệu từ bảng Accounts
            String query = "SELECT *  FROM [HL_Motel].[dbo].[account]";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("userID");
                String mail = resultSet.getString("userMail");
                String password = resultSet.getString("userPassword");
                int role = resultSet.getInt("userRole");

                // Tạo đối tượng Account và thêm vào danh sách
                Account acc = new Account(ID, mail, password, role);
                accounts.add(acc);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return accounts;
    }
     public void insertAcc(String mail, String password, String role) {
        String query = "INSERT INTO [dbo].[account]\n"
                + "           ([userMail]\n"
                + "           ,[userPassword]\n"
                + "           ,[userRole])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
         try {
          
             ps = connection.prepareStatement(query);
             ps.setString(1, mail);
             ps.setString(2, password);
             ps.setString(3, role);
             ps.executeUpdate();
         } catch (Exception e) {
         }
    }
   
public static void main(String args[]){
        DAO dao = new DAO();
        List<Account> acc= dao.getAccounts();
        for(Account acc1 : acc){
            System.out.println(acc);
        }
    }
}
 