package room_model;

import java.io.Serializable;

public class Room implements Serializable {
    private final String roomId;
    private final String building;
    private final String floor;
    private final String number;
    private final String type;
    private final String capacity;

    public Room(String roomId, String building, String floor, String number, String type, String capacity) {
        this.roomId = roomId;
        this.building = building;
        this.floor = floor;
        this.number = number;
        this.type = type;
        this.capacity = capacity;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getBuilding() {
        return building;
    }

    public String getFloor() {
        return floor;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return
                "RoomId: " + roomId +", Capacity: " + capacity+ ", Room Type: "+type;
    }
}
