/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ASUS
 */
public class Room {

    private int roomID;
    private int roomFloor;
    private int roomNumber;
    private int roomSize;
    private float roomFee;
    private String roomImg;

    public Room() {
    }

    public Room(int roomID, int roomFloor, int roomNumber, int roomSize, float roomFee, String roomImg) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomFee = roomFee;
        this.roomImg = roomImg;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public float getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(float roomFee) {
        this.roomFee = roomFee;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
    }

    @Override
    public String toString() {
        return roomID + " " +  roomFloor + " " + roomNumber + " " + roomSize + " " + roomFee + " " + roomImg;
    }
    
    
    

}


   