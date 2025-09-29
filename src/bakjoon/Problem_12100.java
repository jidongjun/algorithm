package bakjoon;

import java.util.Scanner;

public class Problem_12100 {
    static int N;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 보드 크기 입력
        N = sc.nextInt();
        board = new int[N][N];

        // 보드 상태 입력
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = sc.nextInt();
            }
        }
    }
}
