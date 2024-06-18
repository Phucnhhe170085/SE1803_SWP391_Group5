/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;




import Models.Rule;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RuleDAO extends DBContext {
    public List<Rule> getRule() {
        List<Rule> rule = new ArrayList<>();
            String sql = "SELECT [ruleID]\n" +
                            "      ,[ruleName]\n" +
                            "      ,[img]\n" +
                            "      ,[penMoney]\n" +
                            "  FROM [HL_Motel].[dbo].[rule]";
        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Rule Rule = new Rule();

                Rule.setRuleId(rs.getInt("ruleId"));
                Rule.setRuleName(rs.getString("ruleName"));
                Rule.setImg(rs.getString("img"));                             
                Rule.setPenMoney(rs.getFloat("penMoney"));
                rule.add(Rule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rule;    
        
    
    
    }
    public static void main(String[] args) {
        RuleDAO RuleDAO = new RuleDAO();
        List<Rule> rI = RuleDAO.getRule();

        for (Rule rule : rI) {
            System.out.println(rule);

        }
    }
}
