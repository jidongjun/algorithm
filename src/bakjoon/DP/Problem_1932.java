package bakjoon.DP;

import java.io.IOException;
import java.util.Scanner;

public class Problem_1932 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] triangle = new int[n][n];

        // 삼각형 숫자 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i < n ; i++){
            for(int j = 0; j <= i; j++){
                // 왼쪽 끝
                if(j == 0){
                    triangle[i][j] = triangle[i-1][j];
                } else if(j == i){ // 오른쪽 끝
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += triangle[i-1][j-1]+triangle[i-1][j];
                }
            }
        }

        int max = 0;
        for(int val : triangle[n-1]){   // 마지막 행 배열을 순회
            if(val > max){
                max = val;
            }
        }

        System.out.println(max);
    }
}
