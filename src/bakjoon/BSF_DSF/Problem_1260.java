package bakjoon.BSF_DSF;

import java.util.*;
import java.io.*;

public class Problem_1260 {
    static int N;   // 정점의 개수
    static int M;   // 간선의 개수
    static int V;   // 탐색을 시작할 정점의 번호

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1]; // 1부터 시작하는 값을 저장하기 위해 N+1로 지정
        visited = new boolean[N+1];

        for(int i = 1; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 작은순서로 가기 위해 정렬
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        // DFS
        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        // BFS
        visited = new boolean[N+1]; // 방문 배열 초기화
        bfs(V);

        System.out.println(sb.toString());
    }

    static void dfs(int v){
        visited[v] = true;
        sb.append(v).append(" ");
        for(int num : graph[v]){
            if(!visited[num]){
                dfs(num);
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int i : graph[cur]){
                if(!visited[i]){
                    visited[i] = true;
                    bfs(i);
                }
            }
        }
    }
}
