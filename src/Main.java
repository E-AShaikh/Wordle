import java.util.Scanner;

public class Main {
    private static final String WORD = "JUICE";
    private static final String[] DICTIONARY = {"JUICE", "FORCE", "METAL", "LOCAL", "HAPPY"};
    public static void main(String[] args) {
        System.out.println("Write a guess:");
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        for(String line = scanner.nextLine() ; line != null ; line = scanner.nextLine()) {
            line = line.toUpperCase();
            if(line.equals(WORD)) {
                System.out.println("Success!!!");
                return;
            }
            if(!isInDictionary(line)) {
                System.out.println("Word not in dictionary... Try again:");
            } else {
                attempts++;
                System.out.println("Try again:");
                if(attempts > 7) {
                    System.out.println("Game over!");
                    return;
                }
            }
        }

    }

    private static boolean isInDictionary(String word) {
        for(String current : DICTIONARY) {
            if(current.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
