public class IntegerToRoman {

    public static String intToRoman(int num) {
        // Arrays to store the symbols and their corresponding values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumeral = new StringBuilder();

        // Iterate through the symbols and values
        for (int i = 0; i < values.length; i++) {
            // Repeat the symbol while the value is less than or equal to the input number
            while (num >= values[i]) {
                romanNumeral.append(symbols[i]);
                num -= values[i];
            }
        }

        return romanNumeral.toString();
    }

    public static void main(String[] args) {
        int number = 3549; // Example number
        String romanNumber = intToRoman(number);
        System.out.println("Roman Numeral for " + number + " is: " + romanNumber);
    }
}
