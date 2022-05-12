package viewModel.inputValidation;

public class ValidatorManageRooms {

    private static void illegalArgument(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void validateBuilding(String text){
        if (text == null || text.equals("")){
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
        if (num == null || num.equals("")){
            illegalArgument("Floor has to be 1 digits and not empty!");
        }

        boolean isDigit;
        char ch = num.charAt(0);
        isDigit = Character.isDigit(ch);
        if (!isDigit) {
            illegalArgument("Floor has to be 1 digits and not empty!");
        }
    }

    public static void validateCapacity(String num,String capacity){
        int max1 =1;
        int max2=2;
        int max3=3;

        if ((num == null || num.length() > max3|| num.equals(""))&& capacity.equals("auditory")) {

            illegalArgument("Capacity has to be max 3 digits and not empty!");

        }else if ((num == null || num.length() > max1|| num.equals(""))&& capacity.equals("study room")) {
            illegalArgument("Capacity has to be max 1 digits and not empty!");
        }else if((num == null || num.length() > max2|| num.equals(""))&& capacity.equals("class room")){
            illegalArgument("Capacity has to be max 2 digits and not empty!");
        }

        boolean isDigit;

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            isDigit =  Character.isDigit(ch);
            if (!(isDigit)) {
                illegalArgument("Capacity has to be only digits!");
            }
        }

    }
}
