package util;

public final class Util {

    public static String concatenateWords(String... words) {
        StringBuilder result = new StringBuilder();
        if (words != null && words.length > 0) {
            for (String word : words) {
                if (word != null && word.length() != 0) {
                    result.append(word);
                }
            }
        }
        return result.toString();
    }

    public static long computeFactorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Parameter is less than 0.");
        if (n == 0) {
            return 1;
        } else {
            return n * computeFactorial(n - 1);
        }
    }
}
