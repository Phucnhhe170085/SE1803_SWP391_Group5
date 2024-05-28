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

    public RenterList() {
    }

    public RenterList(int userID, String userAvatar, String userName, String userMail, boolean renterHaveRoom, boolean renterStatus) {
        this.userID = userID;
        this.userAvatar = userAvatar;
        this.userName = userName;
        this.userMail = userMail;
        this.renterHaveRoom = renterHaveRoom;
        this.renterStatus = renterStatus;
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
    
    
}
