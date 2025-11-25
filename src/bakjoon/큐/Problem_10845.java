package bakjoon.큐;

import java.util.*;
import java.io.*;

public class Problem_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = -1; // back 출력을 위한 변수

        for(int i = 0; i < N; i++) {
            String command = br.readLine();
            String[] cmd = command.split(" ");

            switch (cmd[0]) {
                case "push":
                    int x = Integer.parseInt(cmd[1]);
                    q.offer(x);
                    last = x;   // 마지막 값 기록
                    break;

                case "pop":
                    Integer val = q.poll();
                    if (val == null)
                        sb.append(-1).append("\n");
                    else
                        sb.append(val).append("\n");
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    Integer front = q.peek();
                    sb.append(front == null ? -1 : front).append("\n");
                    break;

                case "back":
                    if (q.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(last).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
