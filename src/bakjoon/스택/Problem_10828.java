package bakjoon.스택;

import java.util.*;
import java.io.*;

public class Problem_10828 {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int top = -1;   // 스택의 맨 위 인덱스

        for(int i = 0; i < N; i++){
            String command =  br.readLine();

            if(command.startsWith("push")){
                int value = Integer.parseInt(command.split(" ")[1]);
                stack[++top] = value;
            } else if(command.startsWith("pop")){
                if(top == -1) sb.append("-1\n");
                else sb.append(stack[top--]).append("\n");
            } else if(command.startsWith("size")){
                sb.append(top + 1).append("\n");
            } else if (command.startsWith("empth")) {
                sb.append(top == -1 ? 1 : 0).append("\n");
            } else if(command.startsWith("top")){
                if(top == -1) sb.append("-1\n");
                else sb.append(stack[top]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
