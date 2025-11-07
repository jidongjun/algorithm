package bakjoon.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }


        // 맨 처음값을 세팅 (0,1,2,3,4 | 0,1) 등
        int sum = 0;
        for(int i = 0 ; i < k; i++){
            sum += nums[i];
        }
        int best = sum;

        for(int i = k; i < n; i++){
            sum += nums[i];
            sum -= nums[i - k];

            if(sum > best){
                best = sum;
            }
        }

        System.out.println(best);
    }
}
