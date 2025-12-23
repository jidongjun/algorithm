package bakjoon.BSF_DSF;

import java.util.*;
import java.io.*;

public class Problem_15650_DFS {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb.toString());
    }

    public static void dfs(int start, int depth){
        if(depth == M){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++){
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
