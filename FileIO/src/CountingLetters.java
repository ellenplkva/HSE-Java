import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CountingLetters {

    Map<Character, Integer> toCount (FileReader file) throws IOException {
        Map<Character, Integer> letters = new HashMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alphabet.length(); ++i) {
            letters.put(alphabet.charAt(i), 0);
        }
        int l;
        while ((l = file.read() )!= -1) {
            if ((char) l >= 'A' && (char) l <= 'Z' || (char) l >= 'a' && (char) l <= 'z')
                if (letters.get(Character.toLowerCase((char) l)) == 0) {
                    letters.put(Character.toLowerCase((char) l), 1);
                }
                else {
                    letters.put(Character.toLowerCase((char) l), letters.get(Character.toLowerCase((char) l)) + 1);
                }
        }
        return letters;
    }


}
