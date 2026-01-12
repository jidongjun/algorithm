package bakjoon.BSF_DSF.BFS;

import java.util.*;
import java.io.*;

// DFS로 구현하면 최단경로를 보장하지 못함
// 재귀 깊이 제한으로 실패할 수 있음
// BFS(우선 너비 탐색) 출발점으로 부터 거리가 커지는 순서대로 노드를 방문
public class Problem_2178_BFS {
    static int N, M;   // 행, 열
    static int[][] map;
    static int[][] dist; // 시작에서 해당 칸 까지의 거리

    // 상, 하, 좌, 우
    static int[] dy = {-1,1,0,0 };
    static int[] dx = {0, 0,-1,1 };

    static class Point{
        int r,c;
        Point(int r, int c) {
            this.r =r;
            this.c =c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        dist = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine().trim();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

        // 목적지 (N-1, M-1)까지의 거리 출력
        System.out.println(dist[N-1][M-1]);
    }

    static void bfs(){
        Queue<Point> q= new ArrayDeque<>();
        q.add(new Point(0, 0));
        dist[0][0] = 1;

        while(!q.isEmpty()){
            Point p  = q.poll();
            int r = p.r;
            int c = p.c;

            if(r == N-1 && c == M-1){
                break;
            }

            for(int k = 0; k < 4; k++){
                int nr = r + dy[k];
                int nc = c + dx[k];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M){ continue; }
                if(map[nr][nc] == 0) continue;
                if(dist[nr][nc] != 0 )continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.add(new Point(nr, nc));
            }
        }
    }
}
