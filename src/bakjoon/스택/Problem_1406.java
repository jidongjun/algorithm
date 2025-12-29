package bakjoon.스택;

import java.util.*;
import java.io.*;

public class Problem_1406 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // 초기 문자열 커서가 맨 뒤 -> left
        for(char c : text.toCharArray()){
            left.push(c);
        }

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd){
                case "L":
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;

                case "D":
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;

                case "B":
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;

                case "P":
                    char x = st.nextToken().charAt(0);
                    left.push(x);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : left){
            sb.append(c);
        }

        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb);
    }


}
