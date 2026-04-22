package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Day15_대충만든자판 {

    public static void main(String[] args) {
        solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"});
    }

    public static int[] solution(String[] keyMap, String[] targets){
        Map<Character, Integer> map = new HashMap<>();

        // 최소 클릭 수 저장
        for (String key : keyMap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), i+1));
            }
        }

        // target 계산
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            boolean isPossible = true;

            for(char c : targets[i].toCharArray()){
                if(!map.containsKey(c)) {
                    isPossible = false;
                    break;
                }
                sum += map.get(c);
            }

            answer[i] = isPossible ? sum : -1;
        }

        return answer;
    }
}
