package bakjoon.BSF_DSF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1697_BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;
        dist[n] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == k ){
                System.out.println(dist[cur]);
                return;
            }

            int[] next = {cur-1, cur+1, cur*2};
            for(int nx : next){
                if(nx >= 0 && nx <= 100000 && !visited[nx]){
                    visited[nx] = true;
                    dist[nx] = dist[cur] + 1;
                    q.offer(nx);
                }
            }
        }
    }
}
