/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class RenterList {

    private int userID;
    private String userAvatar;
    private String userName;
    private String userMail;
    private boolean renterHaveRoom;
    private boolean renterStatus;
    private String userGender;
    private int roomID;
    private double balance;
    private int roomNumber;
    private int roomFloor;

    public RenterList() {
    }

    public RenterList(String userName, String userGender, int roomID, boolean renterStatus, boolean renterHaveRoom, double balance) {
        this.userName = userName;
        this.userGender = userGender;
        this.roomID = roomID;
        this.renterStatus = renterStatus;
        this.renterHaveRoom = renterHaveRoom;
        this.balance = balance;
    }

    public RenterList(int userID, String userAvatar, String userName, String userMail, boolean renterHaveRoom, boolean renterStatus) {
        this.userID = userID;
        this.userAvatar = userAvatar;
        this.userName = userName;
        this.userMail = userMail;
        this.renterHaveRoom = renterHaveRoom;
        this.renterStatus = renterStatus;
    }

    public RenterList(String userName, double balance, int roomNumber, int roomFloor) {
        this.userName = userName;
        this.balance = balance;
        this.roomNumber = roomNumber;
        this.roomFloor = roomFloor;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public boolean isRenterHaveRoom() {
        return renterHaveRoom;
    }

    public void setRenterHaveRoom(boolean renterHaveRoom) {
        this.renterHaveRoom = renterHaveRoom;
    }

    public boolean isRenterStatus() {
        return renterStatus;
    }

    public void setRenterStatus(boolean renterStatus) {
        this.renterStatus = renterStatus;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }
    
}
