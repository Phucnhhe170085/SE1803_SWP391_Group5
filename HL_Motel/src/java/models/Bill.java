/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Bill {
    private int billId;
    private int roomId;
    private double service;
    private double electric;
    private double roomFee ;
    private double other;
    private double penMoney;
    private Date createAt;
    private Date deadline;
    private Date payAt;

    public Bill() {
    }

    public Bill(int billId, int roomId, double service, double electric, double roomFee, double other, double penMoney, Date createAt, Date deadline, Date payAt) {
        this.billId = billId;
        this.roomId = roomId;
        this.service = service;
        this.electric = electric;
        this.roomFee = roomFee;
        this.other = other;
        this.penMoney = penMoney;
        this.createAt = createAt;
        this.deadline = deadline;
        this.payAt = payAt;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getElectric() {
        return electric;
    }

    public void setElectric(double electric) {
        this.electric = electric;
    }

    public double getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(double roomFee) {
        this.roomFee = roomFee;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public double getPenMoney() {
        return penMoney;
    }

    public void setPenMoney(double penMoney) {
        this.penMoney = penMoney;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getPayAt() {
        return payAt;
    }

    public void setPayAt(Date payAt) {
        this.payAt = payAt;
    }
    
    
}
