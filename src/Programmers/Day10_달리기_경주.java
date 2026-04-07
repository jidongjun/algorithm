package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Day10_달리기_경주 {

    public String[] solution(String[] players, String[] callings){
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++){
            String player = callings[i];
            int idx = map.get(player);

            if(idx > 0){
                // 앞사람 찾기
                String front = players[idx-1];

                // 자리 교체하기
                players[idx-1] = player;
                players[idx] = front;

                // map 업데이트
                map.put(player, idx-1);
                map.put(front, idx);
            }
        }

        return players;
    }

}
