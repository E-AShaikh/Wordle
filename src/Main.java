import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String WORD = "JUICE";
    private static List<String> DICTIONARY = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                DICTIONARY.add(line.toUpperCase());
                line = reader.readLine();
            }
        } catch (IOException err) {
            err.printStackTrace();
            return;
        }
        System.out.println("Write a guess:");
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        for(String line = scanner.nextLine() ; line != null ; line = scanner.nextLine()) {
            line = line.toUpperCase();
            if(line.equals(WORD)) {
                System.out.println("Success!!!");
                return;
            }
            if(!DICTIONARY.contains(line)) {
                System.out.println("Word not in dictionary... Try again:");
            } else {
                attempts++;
                printWordResult(line);
                System.out.println();
                if(attempts > 7) {
                    System.out.println("Game over!");
                    return;
                }
            }
        }

    }

    private static void printWordResult(String word) {
        for(int iter = 0 ; iter < 5 ; iter++) {
            char currentChar = word.charAt(iter);
            if(currentChar == WORD.charAt(iter)) {
                System.out.print("G"); // Green
                continue;
            }
            if(WORD.indexOf(currentChar) > -1) {
                System.out.print("Y"); // Yellow
                continue;
            }
            System.out.print("B"); // Black
        }
        System.out.println();
    }

}
