/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class RenterList {
    private String userName;
    private String userGender;
    private int roomID;
    private boolean renterStatus;
    private boolean renterHaveRoom;
    private int CGRScore;
    private double balance;

    public RenterList() {
    }

    public RenterList(String userName, String userGender, int roomID, boolean renterStatus, boolean renterHaveRoom, int CGRScore, double balance) {
        this.userName = userName;
        this.userGender = userGender;
        this.roomID = roomID;
        this.renterStatus = renterStatus;
        this.renterHaveRoom = renterHaveRoom;
        this.CGRScore = CGRScore;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public boolean isRenterStatus() {
        return renterStatus;
    }

    public void setRenterStatus(boolean renterStatus) {
        this.renterStatus = renterStatus;
    }

    public boolean isRenterHaveRoom() {
        return renterHaveRoom;
    }

    public void setRenterHaveRoom(boolean renterHaveRoom) {
        this.renterHaveRoom = renterHaveRoom;
    }

    public int getCGRScore() {
        return CGRScore;
    }

    public void setCGRScore(int CGRScore) {
        this.CGRScore = CGRScore;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "RenterList{" + "userName=" + userName + ", userGender=" + userGender + ", roomID=" + roomID + ", renterStatus=" + renterStatus + ", renterHaveRoom=" + renterHaveRoom + ", CGRScore=" + CGRScore + ", balance=" + balance + '}';
    }
    
}
