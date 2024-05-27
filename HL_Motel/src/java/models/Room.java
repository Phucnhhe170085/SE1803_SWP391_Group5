package models;

import models.Item;
import models.RoomItem;

/**
 * Represents a Room with various attributes and associated items.
 * This class provides getter and setter methods to access and modify the room details.
 * 
 * Author: ASUS
 */
public class Room {

    private int roomID;
    private int roomFloor;
    private int roomNumber;
    private int roomSize;
    private int roomFee;  // Corrected typo
    private String roomImg;
    private int total;
    private Item item;
    private RoomItem roomItem;  // Changed camel case to maintain consistency

    // Default constructor
    public Room() {
    }

    // Parameterized constructor
    public Room(int roomID, int roomFloor, int roomNumber, int roomSize, int roomFee, 
                String roomImg, int total, Item item, RoomItem roomItem) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomFee = roomFee;  // Corrected typo
        this.roomImg = roomImg;
        this.total = total;
        this.item = item;
        this.roomItem = roomItem;  // Changed camel case to maintain consistency
    }

    // Getter and Setter methods
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

    public int getRoomFee() {
        return roomFee;  // Corrected typo
    }

    public void setRoomFee(int roomFee) {  // Corrected typo
        this.roomFee = roomFee;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public RoomItem getRoomItem() {  // Changed camel case to maintain consistency
        return roomItem;
    }

    public void setRoomItem(RoomItem roomItem) {  // Changed camel case to maintain consistency
        this.roomItem = roomItem;
    }
}
