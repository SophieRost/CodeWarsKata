import java.util.*;

class Bud {
  public static String buddy(long start, long limit) {
    String result = "Nothing";
    long n = start;
    
    while (n <= limit & result.equals("Nothing")) {
      final long nSum = sumOfProperDivisors(n);
      final long m = nSum - 1;
      final long mSum = sumOfProperDivisors(m);
      if (mSum == n + 1 && m > n)
        result = "(" + n + " " + m + ")";
      n++;
    }
    return result;
  }
  
private static long sumOfProperDivisors(long number) {
    long sum = 1;

    for (long i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            if (i == number / i) {
                sum += i;
            } else {
                sum += (i + number / i);
            }
        }
    }
    return sum;
  }
}