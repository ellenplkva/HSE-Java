import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Enter path or name of file");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();
        File file = new File(path);
        FileReader input = new FileReader(file);
        CountingLetters count = new CountingLetters();
        Map<Character, Integer> in = count.toCount(input);
        FileWriter output = new FileWriter("output.txt");
        for(Character key : in.keySet()) {
            Integer value = in.get(key);
            output.write(key + " - " + value + "\n");

        }
        output.close();

    }
}
