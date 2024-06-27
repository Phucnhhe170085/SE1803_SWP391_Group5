package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
    protected Connection conn;
    public DBContext()
    {
        try{
            String user="sa";
            String pass="123456";
            String url="jdbc:sqlserver://localhost:1433;databaseName=HL_Motel";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception ex)
        {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public static void main(String[] args) {
        DBContext db = new DBContext();
        System.out.println(db.conn);
    }
}