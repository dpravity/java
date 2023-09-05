package java01.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NetworkMain4 {

    public static void main(String[] args) throws IOException {
        URL url = null;
        String address = "http://www.codechobo.com/post/free/list";
        BufferedReader input = null;
        String line = "";

        try {
            url = new URL(address);
            input = new BufferedReader(new InputStreamReader(url.openStream()));
            while((line = input.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(input != null){
                input.close();
            }
        }
    }

}
