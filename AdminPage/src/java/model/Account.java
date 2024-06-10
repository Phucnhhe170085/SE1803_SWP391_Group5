/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pc
 */
public class Account {
    private int userID;
    private String userMail;
    private String userPassword;
    private int userRole;
    
    public Account(){
        
    }

    public Account(int userID, String userMail, String userPassword, int userRole) {
        this.userID = userID;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

   

    public int getID() {
        return userID;
    }

    public void setID(int ID) {
        this.userID = ID;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Account{" + "ID=" + userID + ", userMail=" + userMail + ", userPassword=" + userPassword + ", userRole=" + userRole + '}';
    }
    
    
    
}
