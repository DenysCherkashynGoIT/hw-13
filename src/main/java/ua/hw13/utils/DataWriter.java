package ua.hw13.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//class for write data to file (creates it if not exists yet)
public class DataWriter {
    public static <T> File printToFile(T data, File destination) {
        if (!destination.exists()) {
            try {
                destination.getParentFile().mkdirs();
                destination.createNewFile();
            } catch (IOException e) {
                return null;
            }
        }
        try (FileWriter writer = new FileWriter(destination);
             BufferedWriter buffWriter = new BufferedWriter(writer)) {
            buffWriter.write(data.toString());
        } catch (IOException e) {
            return null;
        }
        return destination;
    }

    public static <T> File printToFile(T data, String destination) {
        return printToFile(data, new File(destination));
    }
}
