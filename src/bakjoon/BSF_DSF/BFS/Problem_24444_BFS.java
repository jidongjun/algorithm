package bakjoon.BSF_DSF.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_24444_BFS {

    static ArrayList<Integer>[] graph;
    static int[] order;             // 몇 번째로 방문했는지를 알기 위한 배열

    static int n;
    static int m;
    static int r;

    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        order = new int[n + 1];

        // 초기화작업
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선은 m으로 한다.
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        bfs(r);

        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int r) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(r);
        order[r] = count++;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int pos : graph[cur]) {
                if (order[pos] == 0) {
                    order[pos] = count++;
                    q.offer(pos);
                }
            }
        }
    }
}
