/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.DBContext;
import model.News;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NewDAO extends DBContext{
    public List<News> getNewsList() {
        List<News> news = new ArrayList<>();
        String sql = "SELECT [newID]\n" +
                        "      ,[newTitle]\n" +
                        "      ,[creatAt]\n" +
                        "  FROM [HL_Motel].[dbo].[news]";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                News News = new News();
                News.setNewId(rs.getInt("newId"));
                News.setNewTitle(rs.getString("newTitle"));
                News.setCreateAt(rs.getString("creatAt"));
                news.add(News);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
    
    public List<News> getNewsDetails(int newId) {
        List<News> news = new ArrayList<>();
        String sql = "SELECT [newID]\n" +
                        "      ,[creatAt]\n" +
                        "      ,[newTitle]\n" +
                        "      ,[description]\n" +
                        "      ,[img]\n" +
                        "  FROM [HL_Motel].[dbo].[news] where newID = ?";
        
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, newId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                News News = new News();
                
               News.setNewId(rs.getInt("newId"));
                News.setCreateAt(rs.getString("creatAt"));
                News.setNewTitle(rs.getString("newTitle"));
                News.setDescription(rs.getString("description"));
                News.setImg(rs.getString("img"));
                
                
                news.add(News);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
    
    public static void main(String[] args) {
        NewDAO NewDAO = new NewDAO();
        List<News> rI = NewDAO.getNewsList();
   
        for (News room : rI) {
            System.out.println(room.getCreateAt());

        }
    }
}
