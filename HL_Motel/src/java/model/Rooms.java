package model;

import java.math.BigDecimal;

public class Rooms {

    private int roomID;
    private int roomFloor;
    private int roomNumber;
    private int roomSize;
    private String roomImg;
    private int total;
    private Item item;
    private RoomItem roomitem;
    private BigDecimal roomFee;
    private int roomStatus;
    private int roomOccupant;
    
    public Rooms(Item item, RoomItem roomitem) {
        this.item = item;
        this.roomitem = roomitem;
    }

    public Rooms(int roomID, int roomFloor, int roomNumber, int roomSize, String roomImg, BigDecimal roomFee, int roomStatus, int roomOccupant) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomImg = roomImg;
        this.roomFee = roomFee;
        this.roomStatus = roomStatus;
        this.roomOccupant = roomOccupant;
    }

    public Rooms(int roomID, int roomFloor, int roomNumber, int roomSize, String roomImg, int total) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomImg = roomImg;
        this.total = total;
    }
    
    
    public Rooms(int roomID, int roomFloor, int roomNumber, int roomSize, String roomImg) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomImg = roomImg;
    }
    
    public Rooms(int roomID, int roomFloor, int roomNumber, int roomSize, BigDecimal roomFee) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;   
        this.roomFee = roomFee;
    }
    
    public Rooms() {
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

    public BigDecimal getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(BigDecimal roomFee) {
        this.roomFee = roomFee;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getRoomOccupant() {
        return roomOccupant;
    }

    public void setRoomOccupant(int roomOccupant) {
        this.roomOccupant = roomOccupant;
    }
    
    
    

}


   