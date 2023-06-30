package goit.edu.http.cats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusCheckerTest {
    @ParameterizedTest
    @ValueSource(ints = {404, 200, 500, 300})
    void getStatusImage_CodeExist_GetURL(int code) {
        try {
            String urlAddressExpected = "https://http.cat/" + code + ".jpg";
            assertEquals(HttpStatusChecker.getStatusImage(code), urlAddressExpected);


        } catch (HttpURLException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30, 40, 50, 60, 700, 650, 630, 800, 610, 601})
    void getStatusImage_ArgumentLess100More600_ThrowException(int code) {
        assertThrows(HttpURLException.class, () -> HttpStatusChecker.getStatusImage(code));
    }

    @ParameterizedTest
    @ValueSource(ints = {550, 540, 530, 490, 460, 380, 390, 285, 289, 271, 483})
    void getStatusImage_CodeDoesNotExist_ThrowException(int code) {
        assertThrows(HttpURLException.class, () -> HttpStatusChecker.getStatusImage(code));
    }
}