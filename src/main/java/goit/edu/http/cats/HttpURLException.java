package goit.edu.http.cats;

public class HttpURLException extends Exception{
    public HttpURLException() {
    }

    public HttpURLException(String message) {
        super(message);
    }

    public HttpURLException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpURLException(Throwable cause) {
        super(cause);
    }

    public HttpURLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
