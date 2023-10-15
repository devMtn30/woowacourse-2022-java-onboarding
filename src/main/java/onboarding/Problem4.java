package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char)('A' + 'Z' - c));
            } else if (Character.isLowerCase(c)) {
                result.append((char)('a' + 'z' - c));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
