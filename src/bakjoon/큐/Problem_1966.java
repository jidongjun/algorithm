package bakjoon.큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Problem_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 문서의 갯수
            int M = Integer.parseInt(st.nextToken());   // 문서의 위치

            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            List<Integer> priority = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.offer(new int[]{i, p});
                priority.add(p);
            }

            // 중요도순으로 내림차순 정렬
            priority.sort(Collections.reverseOrder());

            int printCount = 0;
            int priorityIndex = 0;
            while (true) {
                int[] curr = q.poll();
                int idx = curr[0];
                int p = curr[1];

                if (p == priority.get(priorityIndex)) {
                    printCount++;
                    priorityIndex++;

                    if (idx == M) {
                        sb.append(printCount).append("\n");
                        break;
                    }
                } else {
                    q.offer(curr);
                }
            }
        }
        System.out.println(sb);
    }
}
