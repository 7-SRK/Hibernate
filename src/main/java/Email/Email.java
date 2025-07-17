package Email;

import jakarta.activation.DataSource;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import jakarta.activation.*;

public class Email {
    public static void main(String[] args) {

        final String username = "javaemaildemo@gmail.com";
        final  String password = "dfhe nciu jjpl wwyr";
        String to = "sreeramk387@gmail.com,ram07082003@gmail.com";
        String host = "smtp.gmail.com";


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject("Email Through Java");
            message.setText("Hello World");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This email contains an attachment.");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            String filename = "C:\\Users\\Admin\\Downloads\\Training_Document.pdf";
            FileDataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("students.xlsx");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
