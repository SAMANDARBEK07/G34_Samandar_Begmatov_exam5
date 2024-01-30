package org.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.example.Servise.ServiseImpl.UserServiseImpl;
import org.example.Servise.UserServise;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);

    public static void main(String[] args) {
        UserServise userServise=new UserServiseImpl();
        Menu();
        int tanla = scannerInt.nextInt();
        switch (tanla) {
            case 1:

            case 2:
                System.out.println("Enter Username: ");
                String username = scannerStr.nextLine();
                System.out.println("Enter password: ");
                String password=scannerStr.nextLine();
                userServise.login(username, password);
        }

    }

    public static void Menu() {
        System.out.println("""
                1-Register
                2-Log_In
                """);
    }
    public  static  void secondMenu(){
        System.out.println("""
                1-SetPassword
                2-Sana haqida malumot olish
                """);
    }
}

