package bakjoon;

import java.util.*;
import java.io.*;

/**
 * 좌표문제는 기존수학과 다르게 (Y,X)로 풀것을 기억하자.
 */
public class Problem_1926 {
    static int H;   // 세로 (행, row)
    static int W;   // 가로 (열, col)
    static int[][] map;
    static boolean[][] visited;

    // 상, 하, 좌, 우 (행, 열 이동)
    static int[] dh = {-1, 1, 0, 0}; // 행 이동
    static int[] dw = {0, 0, -1, 1}; // 열 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 클래스 변수 H, W 초기화
        H = Integer.parseInt(st.nextToken()); // 세로
        W = Integer.parseInt(st.nextToken()); // 가로

        // 지도 및 방문 배열 초기화
        map = new int[H][W];
        visited = new boolean[H][W];

        // 지도 입력
        for (int row = 0; row < H; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < W; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;    // 그림 개수
        int maxArea = 0;  // 가장 큰 그림 넓이

        // 모든 칸 탐색
        for (int row = 0; row < H; row++) {
            for (int col = 0; col < W; col++) {
                if (!visited[row][col] && map[row][col] == 1) {
                    count++;  // 새로운 그림 발견
                    maxArea = Math.max(maxArea, dfs(row, col));
                }
            }
        }

        // 결과 출력
        System.out.println(count);
        System.out.println(maxArea);
    }

    // DFS로 그림 영역 탐색 및 넓이 계산
    static int dfs(int row, int col) {
        visited[row][col] = true;
        int area = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nr = row + dh[dir];
            int nc = col + dw[dir];

            // 지도 범위 체크
            if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                // 아직 방문하지 않은 1이면 재귀 탐색
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    area += dfs(nr, nc);
                }
            }
        }
        return area;
    }
}
