package server;

import booking.Bookings;
import database.BookingDAO;
import database.BookingImp;
import io.github.cdimascio.dotenv.Dotenv;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;

public class SendReminder implements Runnable{
    private BookingDAO bookingDAO;
    private Dotenv dotenv = Dotenv.load();
    private static final long serialVersionUID = 1L;
    public SendReminder() throws SQLException {
        this.bookingDAO = BookingImp.getInstance();
    }
    public void sendEmail(String recipient ){
        System.out.println("Start to send");
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth","true");
            properties.put("mail.smtp.starttls.enable","true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port","587");

            String myAccountMail = dotenv.get("EMAIL");
            String password = dotenv.get("EMAIL_PASSWORD");
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAccountMail , password);
                }
            });
            Message message = prepareMessage(session , myAccountMail,recipient);
            Transport.send(message);
        }catch (AddressException e){
            System.out.println(e.getMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("message sent");

    }

    private Message prepareMessage(Session session,String myAccountMail,String recipient) throws MessagingException {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountMail));
            message.addRecipient(Message.RecipientType.TO , new InternetAddress(recipient));
            message.setSubject("Reminder");
            String code = "<h1>Hello world</h1>";
            message.setContent(code,"text/html");
            return message;
        }catch (MessagingException m){
            System.out.println(m.getMessage());
        }
        return null;
    }
    @Override
    public void run() {

        while (true){
                try {
                    if((LocalDateTime.now().getMinute() >= 55 && LocalDateTime.now().getMinute() <= 59 ) |
                            (LocalDateTime.now().getMinute() >= 25 && LocalDateTime.now().getMinute() <= 29)){
                        ArrayList<String> emails = bookingDAO.getAllEmailsToReminder();
                        System.out.println(emails);
                        if (emails.size() > 0) {
                            for (String x : emails) {
                                sendEmail(x);
                            }
                        }
                    }
                    Thread.sleep(300000);
                } catch (SQLException | InterruptedException x) {
                    System.out.println(x.getMessage());
                }
        }
    }
}
