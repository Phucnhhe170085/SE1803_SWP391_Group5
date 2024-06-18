package models;

import models.Item;
import models.RoomItem;

import java.math.BigDecimal;

public class Room {

    private int roomID;
    private int roomFloor;
    private int roomNumber;
    private int roomSize;
    private int roomFee;  // Corrected typo
    private String roomImg;
    private int total;
    private Item item;
    private RoomItem roomitem;

    public Room(Item item, RoomItem roomitem) {
        this.item = item;
        this.roomitem = roomitem;
    }

    public Room(int roomID, int roomFloor, int roomNumber, int roomSize, String roomImg, int total) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomImg = roomImg;
        this.total = total;
    }

    public Room(int roomID, int roomFloor, int roomNumber, int roomSize, int roomFee) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomFee = roomFee;
    }

    public Room() {
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

    public RoomItem getRoomitem() {
        return roomitem;
    }

    public void setRoomitem(RoomItem roomitem) {
        this.roomitem = roomitem;
    }

}
