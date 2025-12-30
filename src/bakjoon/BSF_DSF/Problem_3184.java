package bakjoon.BSF_DSF;

import java.util.*;
import java.io.*;

public class Problem_3184 {
    static int r;
    static int c;

    static int sheep;
    static int wolf;

    static char[][] map;
    static boolean[][] visited;

    static int totalSheep = 0; // 최종 살아남은 양
    static int totalWolf = 0;  // 최종 살아남은 늑대

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visited[i][j] && map[i][j] != '#'){
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);

                    // 영역 하나 끝 → 생존 판단
                    if (sheep > wolf) {
                        totalSheep += sheep;
                    } else {
                        totalWolf += wolf;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(totalSheep + " " + totalWolf);
    }

    static void dfs(int r, int c){
        visited[r][c] = true;

        // 실제 현재 양인지, 늑대인지 판단
        if(map[r][c] == 'o') sheep++;
        if(map[r][c] == 'v') wolf++;

        // 4방향 탐색
        for(int d = 0; d < 4; d++){
            int nx = r + dx[d];
            int ny = c + dx[d];

            if (nx >= 0 && nx < r && ny >=0 && ny < c){
                if(!visited[nx][ny] && map[nx][ny] != '#'){
                    dfs(nx, ny);
                }
            }
        }

    }
}
