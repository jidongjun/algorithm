package bakjoon.완전탐색;

import java.util.*;
import java.io.*;

public class Problem_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        int[] ropes = new int[N];
        for(int i = 0; i < N; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int maxWeight = 0;
        for(int i = 0; i < N; i++){
            // 현재 로프를 포함해서 사용할 수 있는 최대 증량 계산
            int weight = ropes[i] * (N - i);
            if(weight > maxWeight){
                maxWeight = weight;
            }
        }

        System.out.println(maxWeight);
    }
}
