package Programmers;

import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {

    /**
     *
     * @param name  그리워 하는 사람의 이름
     * @param yearning  사람별 그리움 점수
     * @param photo 사진에 찍힌 인물의 이름
     * @return
     */
    public int[] solution(String[] name, int[] yearning, String[][] photo){
        Map<String, Integer> scoreMap = new HashMap<>();
        int[] arrAnswer = new int[photo.length];


        for(int i = 0; i < name.length; i++){
            scoreMap.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i ++) {
            int sumScore = 0;
            for (int y = 0; y < photo[i].length; y++) {
                // 없는 사람들은 0점으로 처리
                sumScore += scoreMap.getOrDefault(photo[i][y], 0);
            }
            arrAnswer[i] = sumScore;
        }

        return arrAnswer;
    }
}
