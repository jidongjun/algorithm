package bakjoon.BSF_DSF.DSF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * dfs(현재정점) {
 *     방문처리(현재정점)
 *
 *     for(다음정점 : 현재정점과 연결된 정점들) {
 *         if(아직 안 갔으면) {
 *             dfs(다음정점)
 *         }
 *     }
 * }
 *
 */
public class Problem_24479 {

    static ArrayList<Integer>[] graph;
    static int[] order;
    static int count = 1;

    static int n;
    static int m;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        order = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dsf(r);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dsf(int v) {
        order[v] = count++;

        for (int next : graph[v]) {
            if (order[next] == 0) {
                dsf(next);
            }
        }
    }
}
