package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        boolean isChange = true;
        while(isChange) {
            Character before = 'A'; //문자열은 항상 소문자이기 때문에 대문자를 첫 문자로 사용
            StringBuilder tempStr = new StringBuilder();
            for (char c : cryptogram.toCharArray()) {
                if(!before.equals(c)) {
                    tempStr.append(c);
                } else {
                    tempStr.deleteCharAt(tempStr.length()-1);
                }
                before = c;
            }
            isChange = !cryptogram.contentEquals(tempStr);
            cryptogram = tempStr.toString();
        }
        return cryptogram;
    }
}
