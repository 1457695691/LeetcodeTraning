package cawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GptKey {

    private static void getGptKey() {
        List<String> keyList = new ArrayList<>();
        try {
            URL url = new URL("https://freeopenai.xyz/api.txt");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "text/plain");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("User-Agent", "Mozilla/4.76");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                keyList.add(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        System.out.println("keyList:" + keyList);
    }

    private static void getGptUserAndPasswd() {
        List<String> passList = new ArrayList<>();
        try {
            URL url = new URL("https://freeopenai.xyz/zhyhq.txt\n");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "text/plain");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("User-Agent", "Mozilla/4.76");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                passList.add(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        System.out.println("passList:" + passList);
    }


    public static void main(String[] args) {
        getGptKey();
        getGptUserAndPasswd();
    }
}
