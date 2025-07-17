package DbExcel;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.activation.*;

import java.util.Properties;

public class EmailSender {
    private final String username = "javaemaildemo@gmail.com";
    private final String password = "dfhe nciu jjpl wwyr";

    public void sendEmailWithAttachment(String toEmail, String subject, String body, String attachmentPath) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(body);

        MimeBodyPart attachmentPart = new MimeBodyPart();
        DataSource source = new FileDataSource(attachmentPath);
        attachmentPart.setDataHandler(new DataHandler(source));
        attachmentPart.setFileName("students.xlsx");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        Transport.send(message);
        System.out.println("Email sent successfully.");
    }
}
