/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Rule {
    public int ruleId;
    public String ruleName;
    public String img;
    public int scoreChange;
    public float penMoney; 

    public Rule() {
    }

    public Rule(int ruleId, String ruleName, String img, int scoreChange, float penMoney) {
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.img = img;
        this.scoreChange = scoreChange;
        this.penMoney = penMoney;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getScoreChange() {
        return scoreChange;
    }

    public void setScoreChange(int scoreChange) {
        this.scoreChange = scoreChange;
    }

    public float getPenMoney() {
        return penMoney;
    }

    public void setPenMoney(float penMoney) {
        this.penMoney = penMoney;
    }

    @Override
    public String toString() {
        return "Rule{" + "ruleId=" + ruleId + ", ruleName=" + ruleName + ", img=" + img + ", scoreChange=" + scoreChange + ", penMoney=" + penMoney + '}';
    }
    
    
    
}
