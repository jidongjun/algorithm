package bakjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10844 {

    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 길이가 i 이고 마지막수가 j인 계단의 개수
        int[][] dp = new int[n+1][10];
        for(int j = 1; j <= 9; j++) {
            dp[1][j]  = 1;
        }

        for(int i = 2; i <= n; i++){
            dp[i][0] = dp[i-1][1] % MOD;
            dp[i][9] = dp[i-1][8] % MOD;

            // 마지막 숫자 1~8 인 경우의 수
            for(int j = 1; j <= 8; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
        }

        long answer = 0;
        for(int j = 0; j<=9; j++){
            answer = (answer + dp[n][j]) % MOD;
        }

        System.out.println(answer);
    }
}
