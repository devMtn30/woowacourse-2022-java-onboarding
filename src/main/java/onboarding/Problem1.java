package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidPages(pobi.get(0), pobi.get(1)) || !isValidPages(crong.get(0), crong.get(1))) {
            return -1;
        }

        int maxPobi = getMaxNumber(pobi.get(0), pobi.get(1));
        int maxCrong = getMaxNumber(crong.get(0), crong.get(1));

        if (maxPobi > maxCrong) return 1;
        if (maxPobi < maxCrong) return 2;

        return 0;
    }

    public static boolean isValidPages(int leftPage, int rightPage) {
        return rightPage - leftPage == 1;
    }

    public static int getMaxNumber(int num1, int num2) {
        List<Integer> scores = calculateSumAndProduct(num1);
        scores.addAll(calculateSumAndProduct(num2));

        return scores.stream().max(Integer::compareTo).orElse(0);
    }

    private static List<Integer> calculateSumAndProduct(int num) {
        int sum = 0;
        int product = 1;

        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            product *= digit;
            num /= 10;
        }
        return List.of(sum, product);
    }


}