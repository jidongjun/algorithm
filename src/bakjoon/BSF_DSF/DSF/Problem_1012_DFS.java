package bakjoon.BSF_DSF.DSF;

import java.util.*;
import java.io.*;

/**
 * DFS
 */
public class Problem_1012_DFS {
    static int W;   // 가로
    static int H;   // 세로
    static int C;   // 배추의 갯수

    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());    // 테스트 케이스의 갯수

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[W][H];
            visited = new boolean[W][H];

            // 배추를 심은 위치
            for(int i = 0; i < C; i++){
                st = new StringTokenizer(br.readLine());
                int cw = Integer.parseInt(st.nextToken());
                int ch = Integer.parseInt(st.nextToken());

                map[cw][ch] = 1;
            }

            int count = 0;

            // DFS
            for(int i = 0; i < W; i++){
                for(int j = 0; j < H; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        for(int i = 0; i < 4 ; i++){
            int nr = r + dy[i];
            int nc = c + dx[i];

            if(nr >= 0 && nr < W && nc >=0 &&  nc < H){
                if(map[nr][nc] == 1 && !visited[nr][nc]){
                    dfs(nr, nc);
                }
            }
        }
    }
}
