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
public class Penalty {
    private int penId;
    private int reportId;
    private int accuseId;
    private int roomId;
    private String description;
    private Date penDate;
    private int ruleId;
    public boolean penStatus;

    public Penalty() {
    }

    public Penalty(int penId, int reportId, int accuseId, int roomId, String description, Date penDate, int ruleId, boolean penStatus) {
        this.penId = penId;
        this.reportId = reportId;
        this.accuseId = accuseId;
        this.roomId = roomId;
        this.description = description;
        this.penDate = penDate;
        this.ruleId = ruleId;
        this.penStatus = penStatus;
    }

    public int getPenId() {
        return penId;
    }

    public void setPenId(int penId) {
        this.penId = penId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getAccuseId() {
        return accuseId;
    }

    public void setAccuseId(int accuseId) {
        this.accuseId = accuseId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public boolean isPenStatus() {
        return penStatus;
    }

    public void setPenStatus(boolean penStatus) {
        this.penStatus = penStatus;
    }
    
}