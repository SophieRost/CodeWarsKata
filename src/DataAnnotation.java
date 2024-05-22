import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnnotation {
  public static String main() {
        String filePath = "/Users/sophie/Downloads/Input Qual Coding.txt";
        // Sort the lines
        List<String> sortedLines = decodeAndSortTextFile(filePath);
        // Convert the list to a HashMap
        Map<Integer, String> hashMap = convertListToHashMap(sortedLines);
        // Create the staircase
        List<List<Integer>> stairCase = createStaircase(hashMap.size());
        // Get the last value of each stair
        List<Integer> keyValues = getStairLastValue(stairCase);
        // Replace by assoctiated words
        List<String> associatedValues = keyValues.stream()
                .map(hashMap::get)
                .collect(Collectors.toList()); 

        //return the flatten list
        System.out.println(String.join(" ", associatedValues));
        return  String.join(" ", associatedValues);
    }

    public static List<String> decodeAndSortTextFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort the lines based on the number at the beginning of each line
        Collections.sort(lines, new Comparator<String>() {
            @Override
            public int compare(String line1, String line2) {
                int num1 = Integer.parseInt(line1.split(" ")[0]); // Assuming the number is separated by a space
                int num2 = Integer.parseInt(line2.split(" ")[0]);
                return Integer.compare(num1, num2);
            }
        });
        return lines;
    }  

    public static Map<Integer, String> convertListToHashMap(List<String> list) {
        Map<Integer, String> hashMap = new HashMap<>();
        for (String str : list) {
            String[] splitted = str.split(" ");
            hashMap.put(Integer.parseInt(splitted[0]), splitted[1]);
        }
        return hashMap;
    }

    public static List<List<Integer>> createStaircase(int num) {
        List<List<Integer>> subsets = new ArrayList<>();
        int currentNum = 1;
        int step = 1;

        while (currentNum <= num) {
            List<Integer> subset = new ArrayList<>();       
            for (int i = 1; i <= step && currentNum <= num; i++) {
                subset.add(currentNum++);
            }
            subsets.add(subset);
            step++;
        }
        return subsets;
    }

    public static List<Integer> getStairLastValue(List<List<Integer>> stairs) {
        List<Integer> lastValues = new ArrayList<>();
        stairs.stream().forEach(stair -> {
            lastValues.add(stair.get(stair.size() - 1));
        });
        return lastValues;
    }
}
