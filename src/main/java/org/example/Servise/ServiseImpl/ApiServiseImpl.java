package org.example.Servise.ServiseImpl;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.example.Servise.ApiServise;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ApiServiseImpl implements ApiServise {

    @Override
    public void Api() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the month: ");
        int month = scanner.nextInt();

        System.out.print("Enter the day: ");
        int day = scanner.nextInt();

        scanner.close();
        HttpClient httpClient = HttpClients.createDefault();
        String apiUrl = String.format("https://numbersapi.p.rapidapi.com/%d/%d/date?fragment=true&json=true", month, day);

        try {
            HttpGet request = new HttpGet(apiUrl);
            request.addHeader("X-RapidAPI-Key", "f0c3ed3888msha27820f30084f6bp1579cbjsncfb1620d25a5");
            request.addHeader("X-RapidAPI-Host", "numbersapi.p.rapidapi.com");

            HttpResponse response = httpClient.execute(request);

            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder result = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            System.out.println("API Response: " + result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
