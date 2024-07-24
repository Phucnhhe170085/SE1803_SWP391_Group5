/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigDecimal;
import model.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author ASUS
 */
public class BillDAO extends MyDAO {

    public List<Bill> getBillByRoomID(int id) {
        List<Bill> list = new ArrayList<>();
        String sql
                = "SELECT \n"
                + "    [billID],\n"
                + "    [roomID],\n"
                + "    [service],\n"
                + "    [electric],\n"
                + "    [water],\n"
                + "    [roomFee],\n"
                + "    [other],\n"
                + "    [penMoney],\n"
                + "    [createAt],\n"
                + "    [deadline],\n"
                + "    [payAt],\n"
                + "    ([service] + [electric] + [water] + [roomFee] + [other] + [penMoney]) AS total\n"
                + "FROM \n"
                + "    [HL_Motel].[dbo].[bill]\n"
                + "WHERE [roomID] = ?\n"
                + "ORDER BY \n"
                + "    [createAt] DESC;";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4),
                        rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
                        rs.getDouble(12), rs.getString(9), rs.getString(10), rs.getString(11));
                list.add(bill);
            }
        } catch (SQLException e) {
            // Handle exception as needed
            System.out.println("Fail: " + e.getMessage());

        }
        return list;
    }

    public Bill getBillBybillID(int id) {
        String sql
                = "SELECT \n"
                + "    [billID],\n"
                + "    [roomID],\n"
                + "    [service],\n"
                + "    [electric],\n"
                + "    [water],\n"
                + "    [roomFee],\n"
                + "    [other],\n"
                + "    [penMoney],\n"
                + "    [createAt],\n"
                + "    [deadline],\n"
                + "    [payAt],\n"
                + "    ([service] + [electric] + [water] + [roomFee] + [other] + [penMoney]) AS total\n"
                + "FROM \n"
                + "    [HL_Motel].[dbo].[bill]\n"
                + "WHERE [billID] = ?\n"
                + "ORDER BY \n"
                + "    [createAt] DESC;";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4),
                        rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
                        rs.getDouble(12), rs.getString(9), rs.getString(10), rs.getString(11));
                return bill;
            }
        } catch (SQLException e) {
            // Handle exception as needed
            System.out.println("Fail: " + e.getMessage());

        }
        return null;
    }

    public boolean addFeeById(int roomID, double service, double electric, double water, BigDecimal roomFee, double other, double penMoney, String createAt,
            String deadline, String payAt) {
        String sql = "INSERT INTO [HL_Motel].[dbo].[bill] ([roomID], [service], [electric], [water], [roomFee], [other],"
                + " [penMoney], [createAt], [deadline], [payAt])\n"
                + "VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, roomID);
            ps.setDouble(2, service);
            ps.setDouble(3, electric);
            ps.setDouble(4, water);
            ps.setBigDecimal(5, roomFee);
            ps.setDouble(6, other);
            ps.setDouble(7, penMoney);
            ps.setString(8, createAt);
            ps.setString(9, deadline);
            ps.setString(10, payAt);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Request inserted successfully.");
                return true;
            } else {
                System.out.println("Failed to insert request.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
            return false;
        }

    }

    public boolean updateFeeById(int billID, double service, double electric, double water, BigDecimal roomFee, double other, double penMoney,
            String deadline, String payAt) {
        String sql = "UPDATE [HL_Motel].[dbo].[bill] SET [service] = ?, [electric] = ?, [water] = ?, [roomFee] = ?, "
                + "[other] = ?, [penMoney] = ?, [deadline] = ?, [payAt] = ? WHERE [billID] = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, service);
            ps.setDouble(2, electric);
            ps.setDouble(3, water);
            ps.setBigDecimal(4, roomFee);
            ps.setDouble(5, other);
            ps.setDouble(6, penMoney);
            ps.setString(7, deadline);
            ps.setString(8, payAt);
            ps.setInt(9, billID);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Request updated successfully.");
                return true;
            } else {
                System.out.println("Failed to update request. Room ID may not exist.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Failed to update request: " + e.getMessage());
            return false;
        }
    }

    public boolean updateRequestByID(int requestID, int requestType, String title, String description, String creatAt, String resStatus) {
        String sql = "UPDATE [HL_Motel].[dbo].[request]\n"
                + "SET [requestType] = ?, [title] = ?, [description] = ?, [createAt] = ?, [resStatus] = ?, [reply] = ?\n"
                + "WHERE [requestID] = ?;";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, requestType);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, creatAt);
            ps.setString(5, resStatus);
            ps.setString(6, "");
            ps.setInt(7, requestID);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Request update successfully.");
                return true;
            } else {
                System.out.println("Failed to update request.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Fail: " + e.getMessage());
            return false;
        }

    }

    public UsagePrice getEWPrice() {
        String sql = "Select Electric_Price, Water_Block_Price from usagePrice";
        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                UsagePrice up = new UsagePrice(rs.getDouble(1), rs.getDouble(2));
                return up;

            }
        } catch (SQLException e) {
            // Handle exception as needed
            System.out.println("Fail: " + e.getMessage());

        }
        return null;
    }

    public static void main(String[] args) {
        BillDAO dao = new BillDAO();
//        int billID = 41; // Example room ID
//        double service = 200.0;
//        double electric = 150.0;
//        double water = 100.0;
//        BigDecimal roomFee = new BigDecimal("9900.00");
//        double other = 50.0;
//        double penMoney = 25.0;
//        String deadline = "2024-12-31";
//        String createAt = "2024-07-08";
//        String payAt = null;
//
//        //Call updateFeeById method and check the result
//        boolean result = dao.updateFeeById(billID, service, electric, water, roomFee, other, penMoney, deadline, payAt);
////     boolean result = dao.addFeeById(billID, service, electric, water, roomFee, other, penMoney, createAt, deadline, payAt);
//        if (result) {
//            System.out.println("Fee update successful.");
//        } else {
//            System.out.println("Fee update failed.");
//        }

        UsagePrice price = dao.getEWPrice();
        
        System.out.println(price.getWprice());
    }

}


