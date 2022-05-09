package room_model;

import java.io.Serializable;

public class Room implements Serializable {
    private final String roomId;
    private final char building;
    private final int floor;
    private final int number;
    private final String type;
    private final int capacity;


    public Room(String roomId,char building, int floor, int number, String type, int capacity) {
        this.building = building;
        this.floor = floor;
        this.number = number;
        this.type = type;
        this.capacity = capacity;
        this.roomId= roomId;
    }

    public char getBuilding() {
        return building;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomId() {
        return roomId;
    }

    @Override
    public String toString() {
        return
                "RoomId: " + roomId +
                ", Building: " + building +
                ", Floor: " + floor +
                ", Number: " + number +
                ", Type: " + type +
                ", Capacity: " + capacity;
    }
}
