package bakjoon.슬라이딩윈도우;

import java.util.*;
import java.io.*;

public class Problem_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 순회
        // 이전 숫자를 저장
        // 현재 숫자와 이전 숫자를 비교
        // 현재 숫자와 이전 숫자가 같아면 허용횟수 체크 및 허용횟수 증가
        // 허용횟수를 초과하면 그 자리에서 멈춘다.

        int left = 1;
        int solution = 0;
        int sameCnt = 0;
        int max = 0;

        for(int i = left ; i< N; i++){
            if(nums[i-1] != nums[i]){
                solution++;
            } else {
                sameCnt ++;
                if(sameCnt == K) {
                    left += left+1;
                } else {
                    i += i+1;
                }
            }

            if(solution > max){
                max = solution;
            }
        }

        System.out.println(max);
    }
}
