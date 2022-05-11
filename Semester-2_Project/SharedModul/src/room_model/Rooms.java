package room_model;

import java.io.Serializable;
import java.util.ArrayList;

public class Rooms implements Serializable {
    private ArrayList<Room> roomList;

    public Rooms (){
        this.roomList= new ArrayList<>();
    }
    public void addRoom(Room room){
        roomList.add(room);
    }
    public ArrayList<Room> getRooms(){
        return roomList;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomList=" + roomList +
                '}';
    }
}
