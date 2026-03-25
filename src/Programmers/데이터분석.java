package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 데이터분석 {

    /**
     *
     * @param data  : 정렬한 데이터들이 담긴 이차원 정수 리스트
     * @param ext   : 어떤정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열
     * @param val_ext   : 뽑아낼 정보의 기준값을 나타내는 정수
     * @param sort_by   : 정보를 정렬할 기준이 되는 문자열
     * @return
     */
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by){
        // 1️⃣ 컬럼명 → 인덱스 매핑
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        int extIdx = map.get(ext);
        int sortIdx = map.get(sort_by);

        // 2️⃣ 조건 필터링
        List<int[]> list = new ArrayList<>();

        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                list.add(d);
            }
        }

        // 3️⃣ 정렬
        Collections.sort(list, (a, b) -> a[sortIdx] - b[sortIdx]);

        // 4️⃣ 리스트 → 배열 변환
        int[][] answer = new int[list.size()][4];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
