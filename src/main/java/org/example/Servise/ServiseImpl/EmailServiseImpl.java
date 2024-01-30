package org.example.Servise.ServiseImpl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class EmailServiseImpl implements org.example.Servise.EmailServise {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public boolean Email(String from, String to, String password) {
        String host = "smtp.gmail.com";
        String port = "587";
        Random random = new Random();

        String randomNumber = String.valueOf(random.nextInt(600000, 999999));

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Subject of the email");

            // emailga nima sms jonatishshi yozasla
            message.setText(randomNumber);

            Transport transport = session.getTransport("smtp");
            transport.connect(host,password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Email sent successfully to " + to);
            System.out.print("Enter code (it must be 6 numbers)");
            String code = scanner.nextLine();
            if (randomNumber.equals(code)) {
                return true;
            } else {
                System.out.print("Code is incorrect ❌ Please try again ‼");
                return false;
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
