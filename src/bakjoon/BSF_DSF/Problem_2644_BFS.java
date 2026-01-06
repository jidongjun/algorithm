package bakjoon.BSF_DSF;

import java.util.*;
import java.io.*;
import java.io.IOException;


public class Problem_2644_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 전체 사람의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());   // 찾아야하는 부모
        int b = Integer.parseInt(st.nextToken());   // 찾아야하는 자식

        int m = Integer.parseInt(br.readLine());    // 부모자식들간의 관계의 수

        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        visited[a] = true;
        dist[a] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == b){
                System.out.println(dist[cur]);
                return;
            }

            for(int nx : graph[cur]){
                if(!visited[nx]){
                    visited[nx] = true;
                    dist[nx] = dist[cur] + 1;
                    q.offer(nx);
                }
            }
        }
    }
}
