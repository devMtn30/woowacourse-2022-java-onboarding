package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    // 친구 추천 점수를 저장할 딕셔너리
    static Map<String, Integer> friendScoreDict = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friendRelations : friends) {
            if (friendRelations.get(0).equals(user)) userFriends.add(friendRelations.get(1));
            else if (friendRelations.get(1).equals(user)) userFriends.add(friendRelations.get(0));
        }

        for (List<String> friendRelations : friends) {
            String userA = friendRelations.get(0);
            String userB = friendRelations.get(1);
            if (userA.equals(user) || userB.equals(user)) continue;
            if (userFriends.contains(userA) && !userFriends.contains(userB)) {
                putScoreDict(userB, 10);
            } else if (userFriends.contains(userB) && !userFriends.contains(userA)) {
                putScoreDict(userA, 10);
            }
        }

        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                putScoreDict(visitor, 1);
            }
        }

        return friendScoreDict.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static void putScoreDict(String name, int score) {
        friendScoreDict.put(name, friendScoreDict.getOrDefault(name, 0) + score);
    }
}
