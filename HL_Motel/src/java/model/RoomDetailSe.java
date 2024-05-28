/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class RoomDetailSe {

   private int roomID;
    private String roomNumber;
    private String roomImg;
    private String roomSize;
    private int roomFloor;
    private int singleBed;
    private int bunk;
    private int chair;
    private boolean ceilingFans;
    private boolean airConditional;

    public RoomDetailSe() {
    }

    public RoomDetailSe(int roomID, String roomNumber, String roomImg, String roomSize, int roomFloor, int singleBed, int bunk, int chair, boolean ceilingFans, boolean airConditional) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.roomImg = roomImg;
        this.roomSize = roomSize;
        this.roomFloor = roomFloor;
        this.singleBed = singleBed;
        this.bunk = bunk;
        this.chair = chair;
        this.ceilingFans = ceilingFans;
        this.airConditional = airConditional;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public int getSingleBed() {
        return singleBed;
    }

    public void setSingleBed(int singleBed) {
        this.singleBed = singleBed;
    }

    public int getBunk() {
        return bunk;
    }

    public void setBunk(int bunk) {
        this.bunk = bunk;
    }

    public int getChair() {
        return chair;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }

    public boolean isCeilingFans() {
        return ceilingFans;
    }

    public void setCeilingFans(boolean ceilingFans) {
        this.ceilingFans = ceilingFans;
    }

    public boolean isAirConditional() {
        return airConditional;
    }

    public void setAirConditional(boolean airConditional) {
        this.airConditional = airConditional;
    }

    
    
}
