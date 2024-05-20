package dao;
import models.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBContext {
    Connection conn=null;
   // Connection
    public DBContext(String URL,String userName,String password){
        try {
            //driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //connect
            conn=DriverManager.getConnection(URL, userName, password);
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();      
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
    public DBContext() {
        this("jdbc:sqlserver://localhost:1433;databaseName=",
                "sa","123456");
    }
    public ResultSet getData(String sql){
        ResultSet rs=null;
        Statement state;
        try {
            state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void main(String[] args) {
        new DBContext();
    }
    
    
}
