package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Day19_가장가까운같은글자 {

    public static void main(String[] args) {
        solution("banana");
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        // 위치를 저장하는 Map
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 처음 나온 문자
            if(!map.containsKey(c)) {
                answer[i] = 1;
            } else {
                answer[i] = i - map.get(c);
            }

            map.put(c, i);
        }

        return answer;
    }
}
