package bakjoon.큐;

import java.io.*;
import java.util.*;

public class Problem_11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(q.size() > 1){
            // K-1번 앞에서 뺀 뒤 다시 뒤로 보냄
            for(int i = 0; i< K-1; i++){
                q.offer(q.poll());
            }
            // K번째 사람 제거
            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append(">");
        System.out.println(sb.toString());
    }

}
