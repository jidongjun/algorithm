package bakjoon.DP;

import java.util.*;
import java.io.*;

public class Problem_11052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1]; // dp[n] = n장을 살 때 최대 금액

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= n; k++) {
                dp[n] = Math.max(dp[n], dp[n - k] + P[k]);
            }
        }

        System.out.println(dp[N]);

    }
}
