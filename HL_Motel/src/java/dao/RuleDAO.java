/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GuideLine;
import model.Penalty;
import model.Room;
import model.Rule;

/**
 *
 * @author DAT
 */
public class RuleDAO extends DBContext {

    public ArrayList<Rule> findAll() {
        ArrayList<Rule> rules = new ArrayList<>();
        try {
            String sql = "select * from [rule]";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                rules.add(toRule(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RuleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rules;
    }

    public Rule findById(int id) {
        try {
            String sql = "select * from [rule] where ruleID = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return toRule(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RuleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Rule toRule(ResultSet rs) throws SQLException {
        Rule rule = new Rule();
        rule.setRuleID(rs.getInt("ruleID"));
        rule.setRuleName(rs.getString("ruleName"));
        rule.setImg(rs.getString("img"));
        rule.setScoreChange(rs.getInt("scoreChange"));
        rule.setPenMoney(rs.getDouble("penMoney"));
        return rule;
    }

}
