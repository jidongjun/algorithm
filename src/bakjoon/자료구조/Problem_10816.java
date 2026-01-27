package bakjoon.자료구조;

import java.io.*;
import java.util.*;

public class Problem_10816 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자 카드 빈도 저장
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // 저장된 빈도에서 숫자를 찾는다.
        int M =  Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int m = 0; m < M; m++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(target,0)).append(" ");
        }

        System.out.println(sb);
    }

}
