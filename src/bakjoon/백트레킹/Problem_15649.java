package bakjoon.백트레킹;

import java.util.*;
import java.io.*;

public class Problem_15649 {
    static int N,M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited =  new boolean[N+1];
        arr = new int[M];

        dfs(0);

        System.out.println(sb);
    }


    public static void dfs (int depth){
            if(depth == M){
                for ( int val : arr){
                    sb.append(val).append(" ");
                }
                sb.append("\n");
                return;
            }

            // 1부터 N까지 숫자를 돌면서
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {              // 아직 사용하지 않은 숫자라면
                    visited[i] = true;          // 사용 체크
                    arr[depth] = i;             // 현재 위치에 숫자 넣기
                    dfs(depth + 1);     // 다음 깊이 탐색
                    visited[i] = false;         // 원상복구 (백트래킹)
            }
        }
    }
}
