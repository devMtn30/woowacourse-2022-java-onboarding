package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> invalidNicknames = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (int i = 0; i < forms.size(); i++) {
                List<String> otherForm = forms.get(i);
                if (!otherForm.get(0).equals(email)) {
                    for (int j = 0; j < nickname.length() - 1; j++) {
                        if(otherForm.get(1).contains(nickname.substring(j,j+2))) {
                            invalidNicknames.add(otherForm.get(0));
                            break;
                        }
                    }
                }
            }
        }

        List<String> result = new ArrayList<>(invalidNicknames);
        Collections.sort(result);
        return result;
    }
}
