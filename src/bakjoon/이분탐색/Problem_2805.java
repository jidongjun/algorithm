package bakjoon.이분탐색;

import java.util.*;
import java.io.*;

public class Problem_2805 {
    static int M; // 필요한 나무의 길이
    static int N; // 나무의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 나무의 수
        M = Integer.parseInt(st.nextToken());   // 가져가려고 하는 나무의 길이

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            if(max < trees[i]){
                max = trees[i];
            }
        }

        int min = 0;
        int solution = 0;
        while(min <= max){
            // int mid =  (min + max) / 2;  // 큰 수가 들어 올 시 오버플로우가 발생할 가능성이 있음
            // int mid = min + (max - min) / 2;
            int mid = (min + max) >>> 1; // 오버플로우 방지용 unsigned shift
            int collected = 0;

            for(int height : trees){
                if(height > mid){
                    collected += height - mid;
                }
            }

            if(collected >= M){
                solution = mid;
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        System.out.println(solution);
    }
}
