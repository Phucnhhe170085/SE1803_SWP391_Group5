/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author pc
 */
public class AddnewsDAO extends DBContext{

    public int insertNews(String title, String description, String image, String createAt) {
        int n = 0;
        String query = "INSERT INTO [dbo].[news]\n"
                + "           ([newTitle]\n"
                + "           ,[description]\n"
                + "           ,[img]\n"
                + "           ,[creatAt])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
         try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, title);
             ps.setString(2, description);
             ps.setString(3, image);
             ps.setString(4, createAt);
        
         n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    public static void main(String[] args) {
        AddnewsDAO news = new AddnewsDAO();
        int n = news.insertNews("asfasf","hello world","hhuhuuu","8-7-2024");
        if(n>0) System.out.println("Done");
        else System.out.println("Fail");
    }
}
