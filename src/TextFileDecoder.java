import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileDecoder {

    public static String decodeTextFile(String filePath) {
        StringBuilder decodedText = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                decodedText.append(line).append("\n"); // Appending each line to the decoded text
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decodedText.toString();
    }

    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";
        String decodedText = decodeTextFile(filePath);
        System.out.println(decodedText);
    }
}
