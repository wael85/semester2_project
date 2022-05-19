package room_model;

public enum RoomTypes {
    CLASS_ROOM("class room"),
    AUDITORY_ROOM("auditory"),
    STUDY_ROOM("study room");
    public final String type;

    RoomTypes(String value){
        this.type = value;
    }
}
