package goit.edu.http.cats;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws HttpURLException {
        try {String urlPicture =HttpStatusChecker.getStatusImage(code);
            URL url = new URL(urlPicture);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            String nameFilePicture = "picture" + code + ".jpeg";
            File file = new File(nameFilePicture);
            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                InputStream inputStream = connection.getInputStream();
                byte arry[] = new byte[1024];
                int markRead = 0;
                while ((markRead = inputStream.read(arry)) > 0) {
                    fileOutputStream.write(arry, 0, markRead);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}