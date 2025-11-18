package bakjoon.스택;

import java.util.*;
import java.io.*;

/**
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
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
            } else if (command.startsWith("empty")) {
                sb.append(top == -1 ? 1 : 0).append("\n");
            } else if(command.startsWith("top")){
                if(top == -1) sb.append("-1\n");
                else sb.append(stack[top]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
