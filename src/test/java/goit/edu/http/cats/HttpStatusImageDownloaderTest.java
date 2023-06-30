package goit.edu.http.cats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {

    private List<String> getFileNamesProject() {
        File file = new File(".");
        List<File> projectFiles = Arrays.asList(file.listFiles());
        List<String> listFileNemes = new ArrayList<>();
        for (File file1 : projectFiles) {
            listFileNemes.add(file1.getName());
        }
        return listFileNemes;
    }

    @Test
    void downloadStatusImage_CodeExist() throws HttpURLException {
        List<String> nameBeforeDownloading = getFileNamesProject();
        HttpStatusImageDownloader.downloadStatusImage(404);
        List<String> nameAfterDownloading = getFileNamesProject();
        assertNotEquals(nameBeforeDownloading.contains("picture404.jpeg"),
                nameAfterDownloading.contains("picture404.jpeg"));
    }

    @ParameterizedTest
    @ValueSource(ints = {550, 540, 530, 490, 460, 380, 390, 285, 289, 271, 483})
    void downloadStatusImage_CodeDoesNotExist_ThrowException(int code) {
        assertThrows(HttpURLException.class, () -> HttpStatusImageDownloader.downloadStatusImage(code));
    }
}