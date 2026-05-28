package textsteganographysystem;
import java.util.Scanner;
import java.io.*;
class TextSteganographySystem {
    public static void encodeMessage(String coverText, String secretMessage) {
        try {
            StringBuilder data = new StringBuilder();
            data.append(coverText);
            data.append("\n\n[HIDDEN]: ");
            for (char ch : secretMessage.toCharArray()) {
                data.append(ch);
            }
            FileWriter fw = new FileWriter("encoded.txt");
            fw.write(data.toString());
            fw.close();
            System.out.println("Message encoded successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }
    public static void decodeMessage() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("encoded.txt"));
            String line;
            System.out.println("\n===== FILE CONTENT =====");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== TEXT STEGANOGRAPHY SYSTEM =====");
            System.out.println("1. Encode Message");
            System.out.println("2. Decode Message");
            System.out.println("3. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Cover Text: ");
                    String coverText = sc.nextLine();
                    System.out.print("Enter Secret Message: ");
                    String secretMessage = sc.nextLine();
                    TextSteganographySystem.encodeMessage(coverText, secretMessage);
                    System.out.println("Message encoded successfully!");
                    break;
                case 2:
                    TextSteganographySystem.decodeMessage();
                    break;

                case 3:
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 3);
        sc.close();
    }
}