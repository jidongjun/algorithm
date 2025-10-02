package bakjoon.BSF_DSF;

import java.util.*;
import java.io.*;

public class Problem_2178 {
    static int N,M;
    static int[][] maze;
    static int[][] dist;
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point{
        int r, c;
        public Point(int r,int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i < N; i++){
            String line = br.readLine().trim();
            for(int j = 0; j < M; j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(dist[N-1][M-1]);
    }

    static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0));
        dist[0][0] = 1;

        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int r = cur.r, c = cur.c;

            if(r == N-1 && c == M-1){
                break;
            }

            for(int i=0; i < 4; i++){
                int nr = r + dy[i];
                int rc = c+ dx[i];

                if(nr < 0 || rc < 0 || nr >= N || rc >= M) continue;
                if(maze[nr][rc] == 0) continue;     // 벽
                if(dist[nr][rc] == 1) continue;     // 이미 방문

                dist[nr][rc] = dist[cur.r][cur.c] + 1;
                queue.offer(new Point(nr, rc));
            }
        }
    }
}
