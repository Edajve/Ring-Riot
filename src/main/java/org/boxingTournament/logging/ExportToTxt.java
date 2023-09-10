package org.boxingTournament.logging;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class ExportToTxt {
    public static final String rootProjectPath = Paths.get(System.getProperty("user.dir")) + "/src/main/java/org/boxingTournament";
    private static final String textFilePath = rootProjectPath + "/exports/Results.txt";

    public static void log(String text) {
        try (FileOutputStream stream = new FileOutputStream(textFilePath, true)) {
            byte[] bytes = text.getBytes();
            stream.write(bytes);
            stream.write("\n\n".getBytes());
            System.out.println("Written to file");
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void logConferenceFighters(Conference conference) {
        ExportToTxt.log(conference.getConferenceName() + " fighters:");
        List<Fighter> contestants = conference.getConferenceFighters();
        StringBuilder builder = new StringBuilder();

        try (FileOutputStream stream = new FileOutputStream(textFilePath, true)) {
            contestants.forEach(
                    x -> builder
                            .append(x.getFullName())
                            .append(", ").append(x.getLbs()).append("Lbs")
                            .append(", ").append(x.getHeight())
                            .append(", ").append(x.getBirthPlace())
                            .append("\n")
            );
            byte[] bytes = String.valueOf(builder).getBytes();
            stream.write(bytes);
            stream.write("\n".getBytes());
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void logIntro() {
        log("Starting tournament..");
    }

    public static void logOutro() {
        log("Tournament over :)");
    }
}
