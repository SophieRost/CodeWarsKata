import java.util.HashMap;
import java.util.Map;

public final class GreedIsGood {

    public static int greedy(int[] dice) {

        final Map<Integer, Integer> valuesMap = new HashMap<>();

        for (int i = 0; i < dice.length; i++) {
            int value = dice[i];
            if (!valuesMap.containsKey(value))
                valuesMap.put(value, 0);
            valuesMap.put(value, valuesMap.get(value) + 1);
        }

        Integer finalScore = 0;
        for (Map.Entry<Integer, Integer> entry : valuesMap.entrySet()) {
            finalScore += calculateScore(entry.getKey(), entry.getValue());
        }

        return finalScore;
    };

    private static int calculateScore(Integer value, Integer numberOfDices) {
        int threeScore = 0;
        switch (value) {
            case 1:
                if (numberOfDices > 2) {
                    threeScore = 1000;
                    numberOfDices -= 3;
                }
                return numberOfDices * 100 + threeScore;
            case 5:
                if (numberOfDices > 2) {
                    threeScore = 500;
                    numberOfDices -= 3;
                }
                return numberOfDices * 50 + threeScore;
            default:
                if (numberOfDices > 2)
                    return value * 100;
                return 0;
        }
    }
}