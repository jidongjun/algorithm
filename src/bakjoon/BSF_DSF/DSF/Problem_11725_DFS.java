package bakjoon.BSF_DSF.DSF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_11725_DFS {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }


    static void dfs(int u) {
        visited[u] = true;

        for(int next : graph[u]) {
            if(!visited[next]) {
                parent[next] = u;
                dfs(next);
            }
        }
    }
}
