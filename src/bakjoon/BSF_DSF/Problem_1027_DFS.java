package bakjoon.BSF_DSF;

import java.util.*;
import java.io.*;


public class Problem_1027_DFS {
    static int T, M, N, K;          // 테스트케이스 수, 가로, 세로 ,배추의 수
    static int[][] graph;
    static boolean[][] visited;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0 , -1 , 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }
            int count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(graph[i][j] == 1 && visited[i][j] == false) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }


    static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if( ny > 0 && ny < N && nx > 0 && nx < M){
                if(visited[ny][nx] == false && graph[ny][nx] ==1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
