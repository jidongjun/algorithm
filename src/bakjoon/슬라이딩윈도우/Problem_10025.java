package bakjoon.슬라이딩윈도우;

import java.util.*;
import java.io.*;

public class Problem_10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[1_000_001];
        int maxPos = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());       // 얼음의 좌표
            int g =  Integer.parseInt(st.nextToken());      // 얼음의 양

            arr[x] = g;
            if(maxPos < x) maxPos = x;
        }

        int windowSize = N * 2 + 1;
        long currentSum = 0;
        long maxSum = 0;

        // 초기 윈도우 : 0 ~ min(maxPos, min);
        for(int i = 0; i <= Math.min(maxPos, K); i++){
            currentSum += arr[i];
        }
        maxSum = currentSum;


        for(int i = K+1; i <= N; i++){
            currentSum += arr[i];

            if(i - windowSize >= 0){
                currentSum -= arr[i - windowSize];          // 윈도우를 벗어난 값을 뺀다.
            }
            if(currentSum > maxSum) maxSum = currentSum;
        }

        System.out.println(maxSum);
    }
}
