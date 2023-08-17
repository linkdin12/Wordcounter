import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Wordcount {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text or provide a file path: ");
        String input = scanner.nextLine();
        scanner.close();

        String text;
        if (input.startsWith("file:")) {
            String filePath = input.substring(5);
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return;
            }
        } else {
            text = input;
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        System.out.println("Total word count: " + wordCount);
    }

    private static String readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();
        return sb.toString();
    }

}