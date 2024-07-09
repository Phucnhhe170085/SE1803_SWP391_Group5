/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PenaltyList {
    private int penId;
    private int reportID;
    private int accuseId;
    private int roomId;
    private String description;
    private Date penDate;
    private int ruleId;
    private String ruleName;
    public boolean penStatus;

    public PenaltyList() {
    }

    public PenaltyList(int penId, int roomId, int reportID, int accuseId, String description, Date penDate, int ruleId, String ruleName, boolean penStatus) {
        this.penId = penId;
        this.roomId = roomId;
        this.reportID = reportID;
        this.accuseId = accuseId;
        this.description = description;
        this.penDate = penDate;
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.penStatus = penStatus;
    }

    public int getPenId() {
        return penId;
    }

    public void setPenId(int penId) {
        this.penId = penId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getAccuseId() {
        return accuseId;
    }

    public void setAccuseId(int accuseId) {
        this.accuseId = accuseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPenDate() {
        return penDate;
    }

    public void setPenDate(Date penDate) {
        this.penDate = penDate;
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

    public boolean isPenStatus() {
        return penStatus;
    }

    public void setPenStatus(boolean penStatus) {
        this.penStatus = penStatus;
    }
    @Override
    public String toString() {
        return  penId + ", " + reportID + ", " + accuseId + ", " + roomId + ", " + description + ", " + penDate + ", " + ruleId + ", " + ruleName + ", " + penStatus;
    }  
}