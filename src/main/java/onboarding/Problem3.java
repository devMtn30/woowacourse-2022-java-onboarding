package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 3; i <= number; i++) {
            int temp = i;
            while (temp != 0) {
                int digit = temp % 10;
                if (digit == 3 || digit == 6 || digit == 9) {
                    answer++;
                }
                temp /= 10;
            }
        }
        return answer;
    }
}
