package goit.edu.http.cats;

import java.util.Scanner;

public class HttpImageStatusCli {
    static void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            try {
                HttpStatusImageDownloader.downloadStatusImage(number);
                System.out.println("Image with code " + number + " uploaded");
            } catch (HttpURLException e) {
                System.out.println("There is not image for HTTP status " + number);
            }
        } else {
            System.out.println("Please enter valid number");
        }
    }
}
