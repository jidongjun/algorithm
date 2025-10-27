package bakjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];
        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지면 /2 연산 고려
            if(i % 2 == 0) Math.min(dp[i], dp[i / 2] + 1);

            // 3으로 나누어 떨어지면 /3 연산 고려
            if(i % 3 == 0) Math.min(dp[i], dp[i / 3] + 1);
        }


    }
}
