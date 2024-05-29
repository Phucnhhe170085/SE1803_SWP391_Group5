/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.RenterPenChart;
import Models.RoomItem;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DAO.DBContext;
import Models.RulePenChart;

/**
 *
 * @author Admin
 */
public class SecurityDAO extends DBContext {

    public List<RenterPenChart> getTopPenRenter() {
        List<RenterPenChart> pen = new ArrayList<>();
        String sql = "select top 5 p.roomID, SUM(r.penMoney) as penMoney from penalty p join [rule] r on p.ruleID = r.ruleID group by p.roomID order by penMoney DESC";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RenterPenChart RenterPenChart = new RenterPenChart();

                RenterPenChart.setRoomID(rs.getInt("roomID"));
                RenterPenChart.setPenMoney(rs.getFloat("penMoney"));
                pen.add(RenterPenChart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pen;
    }

    public List<RulePenChart> getTopPenRule() {
        List<RulePenChart> pen = new ArrayList<>();
        String sql = "SELECT TOP 3 r.ruleName, COUNT(p.ruleID) AS Number\n"
                + "FROM penalty p\n"
                + "JOIN [rule] r ON p.ruleID = r.ruleID\n"
                + "GROUP BY p.ruleID, r.ruleName\n"
                + "ORDER BY Number DESC;";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RulePenChart RulePenChart = new RulePenChart();

                RulePenChart.setRuleName(rs.getString("ruleName"));
                RulePenChart.setNumber(rs.getInt("Number"));
                pen.add(RulePenChart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pen;
    }

    public static void main(String[] args) {
        SecurityDAO SecurityDAO = new SecurityDAO();
        List<RulePenChart> rI = SecurityDAO.getTopPenRule();

        for (RulePenChart room : rI) {
            System.out.println(room);

        }
    }
}
