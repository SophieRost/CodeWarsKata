import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ArrayUtils {
    
    public static int[] flatten (int[][] arr) {
        
        //declare a list that contain streams
        List<Integer> streamList = new ArrayList<>();
        
        //for each loop to convert array in arr to stream and add the stream to streamList
        for (int[] array : arr) {
            Arrays.stream(array)
            .forEach(streamList::add);
        }
        
        //flatten the stream using toArray method
        final int[] flattenArray = streamList.stream().mapToInt(Integer::intValue).toArray();
        return flattenArray;
    }  


    public static int[] arrayDiff(int[] a, int[] b) {
        return Arrays.stream(a)
                .filter(e -> Arrays.stream(b).noneMatch(n -> n == e))
                .toArray();
      }
}
