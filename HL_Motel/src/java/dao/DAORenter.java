package dao;

import dao.DBContext;
import models.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DAORenter extends DBContext {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<News> getAllNews() {
        List<News> list = new ArrayList<>();
        String query = "SELECT * FROM news";
        try {
            conn = connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Assuming the News constructor takes three parameters: String, String, String
                News news = new News(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(news);
            }
        } catch (SQLException e) {
            // Handle SQL exceptions appropriately, such as logging or rethrowing
            e.printStackTrace();
        } finally {
            // Close resources in finally block to ensure they are always closed
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        DAORenter dao = new DAORenter();

        // Fetch news from the database
        List<News> newsList = dao.getAllNews();

        // Print news details
        for (News news : newsList) {
            System.out.println("ID: " + news.getUserName());
            System.out.println("Content: " + news.getNewsTitle());
            System.out.println("Date: " + news.getNewDes());
            System.out.println("-----------");
        }
    }
}
