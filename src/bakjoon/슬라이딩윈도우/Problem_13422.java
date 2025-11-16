package bakjoon.슬라이딩윈도우;

import java.util.*;
import java.io.*;

public class Problem_13422 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int testCnt = 0; testCnt < t;  testCnt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n =  Integer.parseInt(st.nextToken());      // 마을에 있는 집의 수
            int m =  Integer.parseInt(st.nextToken());      // 도둑이 돈을 훔칠 연속된 집의 갯수
            int k =  Integer.parseInt(st.nextToken());      // 자동 방범 장치가 작동하는 최소 돈의 양

            int[] homes = new int[n];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                homes[i] = Integer.parseInt(st.nextToken());
            }

            // 예외 : 모든 집을 다 훔치는 경우에는 원통 의미 X
            if(n == m){
                int total = 0;
                for(int val : homes){
                    total += val;
                }
                sb.append(total < k ? 1 : 0).append("\n");
                continue;
            }

            int sum = 0;
            for (int i = 0; i < m; i++) sum += homes[i];

            int count = 0;
            if(sum < k) count++;

            for(int i = 1; i < n; i++){
                sum -= homes[i -1];
                sum += homes[(i+m-1) % n];      // 처음으로 돌아가야하는 상황일때는 %n
                if(sum < k) count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
