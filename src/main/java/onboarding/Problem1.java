package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi.get(0), pobi.get(1))
                || isException(crong.get(0), crong.get(1))) {
            return -1;
        }

        int maxPobi = getMaxNumber(pobi.get(0), pobi.get(1));
        int maxCrong = getMaxNumber(crong.get(0), crong.get(1));

        if (maxPobi > maxCrong) return 1;
        if (maxPobi < maxCrong) return 2;

        return 0;
    }

    public static boolean isException(int leftPage, int rightPage) {
        return rightPage - leftPage != 1;
    }

    public static int getMaxNumber(int num1, int num2) {
        List<Integer> numbers = Stream.concat(
                convertMultiSum(num1).stream(),
                convertMultiSum(num2).stream())
                .collect(Collectors.toList());

        return Collections.max(numbers);
    }

    private static List<Integer> convertMultiSum(int num) {
        int sum = 0;
        int multi = 1;

        while (num !=0) {
            sum += num % 10;
            multi *= num % 10;
            num /= 10;
        }
        return List.of(multi, sum);
    }


}