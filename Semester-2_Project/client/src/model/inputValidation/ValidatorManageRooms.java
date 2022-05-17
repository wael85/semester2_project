package model.inputValidation;

public class ValidatorManageRooms {

    public static void validatorCreateRoom(String building, String floor, String number, String type, String capacity){
        validateBuilding(building);validateFloor(floor);validateNumber(number);validateCapacity(capacity,type);
    }

    private static void illegalArgument(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void validateBuilding(String text){
        if (text == null || text.equals("")|| text.length()>1){
            illegalArgument("Building has to be 1 capitalLetter and not empty!");
        }

        char ch = text.charAt(0);
        boolean uppercase;
        uppercase = Character.isUpperCase(ch);
        if (!uppercase) {
            illegalArgument("Building has to be 1 capitalLetter and not empty!");
        }

    }
    public static void validateNumber(String num){
        int max=2;
        if ((num == null || num.length() > max|| num.equals(""))) {
            illegalArgument("Room number has to be max 2 digits and not empty!");
        }
        boolean isDigit;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            isDigit =  Character.isDigit(ch);
            if (!(isDigit)) {
                illegalArgument("Room number has to be only digits!");
            }
        }
    }
    public static void validateFloor(String num){
        if (num == null || num.equals("")||num.length()>2){
            illegalArgument("Floor has to be 1 digits and not empty!");
        }

        boolean isDigit;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            isDigit = Character.isDigit(ch);
            if (!isDigit) {
                illegalArgument("Floor has to be max 2 digits and not empty!");
            }
        }

    }

    public static void validateCapacity(String capacity,String type){
        int max1 =1;
        int max2=2;
        int max3=3;

        if ((capacity == null || capacity.length() > max3|| capacity.equals(""))&& type.equals("auditory")) {

            illegalArgument("Capacity has to be max 3 digits and not empty!");

        }else if ((capacity == null || capacity.length() > max1|| capacity.equals(""))&& type.equals("study room")) {
            illegalArgument("Capacity has to be max 1 digits and not empty!");
        }else if((capacity == null || capacity.length() > max2|| capacity.equals(""))&& type.equals("class room")){
            illegalArgument("Capacity has to be max 2 digits and not empty!");
        }

        boolean isDigit;

        for (int i = 0; i < capacity.length(); i++) {
            char ch = capacity.charAt(i);

            isDigit =  Character.isDigit(ch);
            if (!(isDigit)) {
                illegalArgument("Capacity has to be only digits!");
            }
        }

    }
}
