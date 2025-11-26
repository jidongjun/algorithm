package bakjoon.큐;

import java.util.*;
import java.io.*;

public class Problem_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        while (q.size() > 1) {
            q.poll();              // 1. 맨 위 버리기
            q.offer(q.poll());     // 2. 다음 카드를 맨 뒤로 보내기
        }

        System.out.println(q.poll());
    }
}
