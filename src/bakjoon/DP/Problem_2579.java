package bakjoon.DP;

import java.util.*;
import java.io.*;

public class Problem_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());

        int[] dp =  new int[n+1];
        int[] floor  = new int[n+1];

        for(int i = 1; i <= n; i++){
            floor[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1){
            System.out.println(floor[1]);
            return;
        }

        dp[1] = floor[1];
        dp[2] = floor[1] + floor[2];

        if(n >= 3){
            dp[3] = Math.max(
                    dp[1] + floor[3],
                    floor[2] + floor[3]
                    );
        }

        for(int i = 4; i <= n; i++){
            dp[i] = Math.max(
                    dp[i-2] + floor[i],
                    dp[i-3] + floor[i-1] + floor[i]
                    );
        }

        System.out.println(dp[n]);

    }
}
