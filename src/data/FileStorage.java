package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileStorage {

    private static final String LOG_FILE = "data/transactions_log.txt";

    // Appends a record (e.g., bill summary) to a text file for persistence/proof of transactions
    public static void appendToFile(String content) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(content);
            pw.println("=========================================");
        } catch (IOException e) {
            System.out.println("Warning: Could not write to log file. " + e.getMessage());
        }
    }
}
