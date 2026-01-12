package bakjoon.BSF_DSF.DSF;

import java.util.*;
import java.io.*;

public class Problem_11724_DFS {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N;   // 정점의 개수
    static int M;   // 간선의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1]; // 1부터 시작하는 값을 저장하기 위해 N+1로 지정
        visited = new boolean[N+1];

        for(int i = 1; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);    // 양쪽 끝점이 존재하는 그래프이므로 각 지점들을 연결해주어야 함
            graph[b].add(a);
        }

        int count =0;
        for(int i = 1; i < N+1; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }


    static void dfs(int i){
        if(visited[i]) return;
        visited[i] = true;

        for(int num : graph[i]){
            if(!visited[num]){
                dfs(num);
            }
        }
    }
}
