package room_model;

import java.io.Serializable;
import java.util.ArrayList;

public class Rooms implements Serializable {
    private static final long serialVersionUID = 6529685098267757691L;
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
    public ArrayList<Room> getRoomsByType(String type){
        ArrayList<Room> rooms =new ArrayList<>();
        for (Room r:roomList ) {
            if(r.getType().equals(type)){
                rooms.add(r);
            }
        }
        return rooms;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomList=" + roomList +
                '}';
    }
}
