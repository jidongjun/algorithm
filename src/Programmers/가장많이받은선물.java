package Programmers;


import java.util.HashMap;
import java.util.Map;

/**
 * 선물을 주고받은 기록이 있다면 => 이번달까지 두사람 사이에 더많은 선물을 준 사람
 * 선물을 주고받은 기록이 없다면 => 선물지수가 더 큰 사람이 선물 받기
 *  선물지수 : 준 선물 - 받은선물
 *
 *  이름 -> MAP
 *  선물기록 -> 2차원배열
 *  사람 비교 -> 이중 for문
 */
public class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts){
        int n = friends.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(friends[i], i);
        }

        int[][] gift = new int[n][n];
        int[] giftScore = new int[n];

        for(String g : gifts){
            String[] s = g.split(" ");
            int from = map.get(s[0]);
            int to = map.get(s[1]);

            gift[from][to]++;
            giftScore[from]++;
            giftScore[to]--;
        }

        int[] nextMonth = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(gift[i][j] > gift[j][i]){
                    nextMonth[i]++;
                } else if(gift[i][j] < gift[j][i]){
                    nextMonth[j]++;
                } else{
                    if(giftScore[i] > giftScore[j]){
                        nextMonth[i]++;
                    } else if(giftScore[i] < giftScore[j]){
                        nextMonth[j]++;
                    }
                }
            }
        }

        int answer = 0;
        for(int x : nextMonth){
            answer  = Math.max(answer, x);
        }

        return answer;
    }
}
