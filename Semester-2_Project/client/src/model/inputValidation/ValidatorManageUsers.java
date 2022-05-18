package model.inputValidation;

public class ValidatorManageUsers {
    public final static int MINIMAL_LENGTH = 8;
    public final static int MINIMAL_LENGTH_USERNAME = 3;


    public static void validatorCreateGuest(String CVR, String password, String companyName, String email, String phone){
        validateUsername(CVR); validatePassword(password); validateEmptyField(companyName); validatePhone(phone);
        validateEmail(email);
    }

    public static void validatorCreateAdmin(String staffNumber, String password, String firstName, String lastName, String email, String phone){
        validateUsername(staffNumber);validatePassword(password); validateEmptyField(firstName);validateEmptyField(lastName);
        validatePhone(phone); validateEmail(email);
    }

    public static void validatorCreateStudent(String studentId, String password, String firstName, String lastName, String email, String phone){
        validateUsername(studentId);validatePassword(password); validateEmptyField(firstName);validateEmptyField(lastName);
        validatePhone(phone); validateEmail(email);
    }

    public static void validatorCreateTeacher(String staffNumber, String password, String firstName, String lastName, String email, String phone)
    {
        validateUsername(staffNumber);validatePassword(password); validateEmptyField(firstName);validateEmptyField(lastName);
        validatePhone(phone); validateEmail(email);
    }
    private static void illegalArgument(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            illegalArgument("Email cannot be empty!");
        }
        String[] parts = email.split("@");
        if (parts.length == 1) {
            illegalArgument("Email must contain @ !");
        }
        if (parts.length > 2) {
            illegalArgument("Email must not contain more than one @ !");
        }
        if (!parts[1].contains(".")) {
            illegalArgument("Domain must have several parts!");
        }
    }


    public static void validateUsername(String username) throws IllegalArgumentException {

        if (username == null || username.length() < MINIMAL_LENGTH_USERNAME) {
            throw new IllegalArgumentException("Username needs " + MINIMAL_LENGTH_USERNAME + " or more digits!");
        }

    }

    public static void validatePassword(String password) throws IllegalArgumentException {
        if (password == null || password.length() < MINIMAL_LENGTH) {
            throw new IllegalArgumentException("Password needs " + MINIMAL_LENGTH + " or more characters!");
        }
        boolean lowercase = false;
        boolean uppercase = false;
        boolean digit = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            lowercase = lowercase || Character.isLowerCase(ch);
            uppercase = uppercase || Character.isUpperCase(ch);
            digit = digit || Character.isDigit(ch);
        }
        if (!(lowercase && uppercase && digit)) {
            throw new IllegalArgumentException("Password needs both lower case letters, upper case letters and digits!");
        }
    }

    public static void validatePhone(String phone) throws IllegalArgumentException {
        if (phone == null || phone.length() < MINIMAL_LENGTH) {
            throw new IllegalArgumentException("Tlf.number needs " + MINIMAL_LENGTH + " or more characters!");
        }

        boolean isDigit;
        for (int i = 0; i < phone.length(); i++) {
            char ch = phone.charAt(i);

            isDigit =  Character.isDigit(ch);
            if (!(isDigit)) {
                throw new IllegalArgumentException("Tlf.number needs only digits!");
            }
        }
    }

    public static void validateEmptyField(String txt) throws IllegalArgumentException{
        if (txt == null || txt.equals("")){
            throw new IllegalArgumentException("Field is empty!");
        }
    }
}
