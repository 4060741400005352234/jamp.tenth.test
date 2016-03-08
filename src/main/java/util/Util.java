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
}
