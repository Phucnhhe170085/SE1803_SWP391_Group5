/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
                + "    [GreenRoom].[dbo].[bill]\n"
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
                + "    [GreenRoom].[dbo].[bill]\n"
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

    public boolean addFeeById(int roomID, double service, double electric, double water, double roomFee, double other, double penMoney, String createAt,
            String deadline, String payAt) {
        String sql = "INSERT INTO [GreenRoom].[dbo].[bill] ([roomID], [service], [electric], [water], [roomFee], [other], [penMoney], [createAt], [deadline], [payAt])\n"
                + "VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, roomID);
            ps.setDouble(2, service);
            ps.setDouble(3, electric);
            ps.setDouble(4, water);
            ps.setDouble(5, roomFee);
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

    public boolean updateFeeById(int roomID, double service, double electric, double water, double roomFee, double other, double penMoney,
            String deadline, String payAt) {
        String sql = "UPDATE [GreenRoom].[dbo].[bill] SET [service] = ?, [electric] = ?, [water] = ?, [roomFee] = ?, [other] = ?, [penMoney] = ?, [deadline] = ?, [payAt] = ? WHERE [roomID] = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, service);
            ps.setDouble(2, electric);
            ps.setDouble(3, water);
            ps.setDouble(4, roomFee);
            ps.setDouble(5, other);
            ps.setDouble(6, penMoney);
            ps.setString(7, deadline);
            ps.setString(8, payAt);
            ps.setInt(9, roomID);

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
        String sql = "UPDATE [GreenRoom].[dbo].[request]\n"
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
        String sql = "SELECT  [Electric_Price]\n"
                + "      ,[Water_Block_Price]\n"
                + "  FROM [GreenRoom].[dbo].[Usage_Price]";
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
        Bill bill = new Bill();
        boolean result = dao.addFeeById(1, 100000, 100000, 100000, 100000, 100000, 100000, "2022-09-30 00:00:00.000", "2022-09-30 00:00:00.000", null);
        System.out.println(result);
    }
}
