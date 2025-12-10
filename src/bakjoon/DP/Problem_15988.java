package bakjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;

public class Problem_15988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            int t = Integer.parseInt(br.readLine());

            int[] dp = new int[Math.max(t+1,4)];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i = 4; i<= t; i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3] % 1_000_000_009;
            }

            sb.append(dp[t]).append("\n");
        }

        System.out.println(sb);
    }

}
