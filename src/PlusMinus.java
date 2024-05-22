import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlusMinus {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void main(List<Integer> arr) {
    // Write your code here
    // Count the number of positif, negative and null
    Map<String, Integer> countResult = countIntegers(arr);
    // Get the ratio for each type
    List<Double> ratios = getRatios(countResult, arr.size());
    // Print ratios
    ratios.stream().forEach(ratio -> System.out.println(ratio));
    }
    


    public static Map<String, Integer> countIntegers(List<Integer> integerList) {
        // Create a new HashMap to store the counts of integers
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("positive", 0);
        countMap.put("negative", 0);
        countMap.put("null", 0);

        // Use Java streams to iterate through the list and update the counts
        integerList.forEach(element -> {
            if (element > 0)
                countMap.put("positive", countMap.get("positive") + 1);
            else if (element < 0)
                countMap.put("negative", countMap.get("negative") + 1);
            else
                countMap.put("null", countMap.get("null") + 1);
        });

        // Return the HashMap containing the counts of integers
        return countMap;
    }

    public static List<Double> getRatios(Map<String, Integer> countIntegers, int total) {
        List<Double> ratios = new ArrayList<>();
        
        // Iterate over the entries in the map
        for (Map.Entry<String, Integer> entry : countIntegers.entrySet()) {
            // Calculate the ratio for each count
            double ratio = (double) entry.getValue() / total;
            ratios.add(ratio);
        }
        
        return ratios;
    }

}
