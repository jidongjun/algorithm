package bakjoon.BSF_DSF;

import java.util.*;
import java.io.*;

public class Problem_2667_DFS {
    static int N;           // 지도의 크기
    static int[][] map;       // 정사각형을 담을 Map
    static boolean[][] visited;   // 방문여부

    // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuffer sb = new StringBuffer();   // 놓친 것
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];            // 놓친것
        

        for(int i = 0; i < N; i++){
            char[] number = br.readLine().toCharArray();
            for(int j = 0; j < number.length; j++){
                map[i][j] = number[j];
            }
        }

        List<Integer> complex = new ArrayList<>();      //

        for(int i = 0; i < N; i++){                     // 행 (row, y축)
            for(int j = 0; j < N; j++){                 // 열 (col, x축)
                if(!visited[i][j] && map[i][j] == 1){
                    int size = dfs(i, j);
                    complex.add(size);
                }
            }
        }

        Collections.sort(complex);  // 오름차순 정렬

        sb.append(complex.size()).append("\n");
        for(int i = 0; i < complex.size(); i++){
            sb.append(complex.get(i)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int dfs(int r, int c){
        visited[r][c] = true;
        int count = 1;
        for(int i = 0; i < 4; i++){
            int nr = r + dy[i];
            int nc = c + dx[i];

            if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                if(!visited[nr][nc] && map[nr][nc] == 1){
                    count += dfs(nr, nc);
                }
            }
        }


        return count;
    }

}
