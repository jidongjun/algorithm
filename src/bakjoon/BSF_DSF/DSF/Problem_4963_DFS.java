package bakjoon.BSF_DSF.DSF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_4963_DFS {
    static int W, H;
    static int[][] map;
    static boolean[][] visited;

    // 상,하,좌,우,대각선
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1, 0,1,-1, 1,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while(true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());           // 열
            H = Integer.parseInt(st.nextToken());           // 행

            if(W == 0 && H == 0) break;

            map = new int[H][W];
            visited = new boolean[H][W];

            // 지도 입력
            for(int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++) {
                    map[i][j] =  Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(map[i][j] == 1 && visited[i][j] == false) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }


    }

    static void dfs(int row, int col) {
        visited[row][col] = true;

        for(int dir = 0; dir < 8; dir++){
            int nx = col + dx[dir];
            int ny = row + dy[dir];

            if(nx >= 0 && nx < W && ny >= 0 && ny < H){
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    dfs(ny,nx);
                }
            }
        }
    }
}
