public class RgbToHex {

    public static String rgb(int r, int g, int b) {
        final int[] colorValues = { getRoundedValue(r), getRoundedValue(g), getRoundedValue(b) };
        final String[][] result = getHexChars(colorValues);
        return flatten(result);
    }

    private static int getRoundedValue(int value) {
        if (value < 0)
            return 0;
        else if (value > 255)
            return 255;

        return value;
    }

    private static String[][] getHexChars(int[] array) {
        String[][] chars = new String[3][2];
        int colorIndex = 0;
        for (int colorValue : array) {
            chars[colorIndex] = getHexPair(colorValue);
            colorIndex++;
        }
        return chars;
    }

    private static String flatten(String[][] twoDArray) {
        StringBuilder result = new StringBuilder();

        for (String[] array : twoDArray) {
            for (String s : array)
                result.append(s);
        }
        return result.toString();
    }

    private static String[] getHexPair(int value) {
        final int quotient = value / 16;
        final int remainder = value % 16;

        final String[] pair = { digitToString(quotient), digitToString(remainder) };
        return pair;
    }

    private static String digitToString(int i) {
        if (i < 10)
            return String.valueOf(i);
        final String[] alphabetic = { "A", "B", "C", "D", "E", "F" };
        return alphabetic[i - 10];
    }

}