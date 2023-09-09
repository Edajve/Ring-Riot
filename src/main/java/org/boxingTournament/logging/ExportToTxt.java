package org.boxingTournament.logging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class ExportToTxt {
    public static final String rootProjectPath = Paths.get(System.getProperty("user.dir")) + "/src/main/java/org/boxingTournament";

    public static void log(String text) {
        String textFilePath = rootProjectPath + "/exports/Results.txt";

        try (FileOutputStream stream = new FileOutputStream(textFilePath, true)) {
            byte[] bytes = text.getBytes();
            stream.write(bytes);
            stream.write("\n\n".getBytes());
            System.out.println("Written to file");
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
