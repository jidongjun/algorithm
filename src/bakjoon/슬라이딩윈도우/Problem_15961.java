package bakjoon.슬라이딩윈도우;

import java.util.*;
import java.io.*;

public class Problem_15961 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

        int[] belt = new int[n];
        for(int i = 0; i < n; i++){
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] freq = new int[n];    // 초밥의 빈도를 저장
        int unique = 0;

        // 초기값을 저장
        for(int i = 0; i < k; i++){
            if(freq[i] == 0) unique++;
            freq[i]++;
        }

        int max = unique;
        // 쿠폰에 적힌 초밥
        if(freq[c] == 0) max++;

        // 슬라이딩 윈도우
        for(int i = 1; i <n; i++){
            int left = belt[i-1];   // 왼쪽
            int right = belt[(i+k-1) % n]; // 오른쪽(원형처리)

            // 왼쪽 제거
            freq[left]--;
            if(freq[left] == 0) unique--;

            // 오른쪽 추가
            freq[right]++;
            if(freq[right] == 0) unique++;

            int current = unique;

            // 쿠폰 초밥 추가
            if(freq[c] == 0) current++;

            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
