package database;
import io.github.cdimascio.dotenv.Dotenv;
public class StudentImp {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.out.println(dotenv.get("USER_NAME"));
        System.out.println(dotenv.get("DATABASE_URL"));
    }
}
