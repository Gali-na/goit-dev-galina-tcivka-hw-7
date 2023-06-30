package goit.edu.http.cats;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class HttpStatusChecker {
    public static String getStatusImage(int code) throws HttpURLException {
        String urlAddress="https://http.cat/"+code+".jpg";
         if (code<100 || code>600){
             throw new HttpURLException("Status code invalid");
         }
         else {
             try {
                 URL url = new URL(urlAddress);
                 HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                 if ((connection.getResponseCode()) == 404) {
                     throw new HttpURLException("Status code invalid");
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
             return urlAddress;
    }
}

