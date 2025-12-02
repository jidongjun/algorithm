package bakjoon.디큐;

import java.util.*;
import java.io.*;

public class Problem_10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch(order){
                case "push_front":
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(!q.isEmpty()){
                        Integer firstNum = q.pollFirst();
                        sb.append(firstNum).append('\n');
                    } else {
                        sb.append("-1").append('\n');
                    }

                    break;
                case "pop_back":
                    if(!q.isEmpty()){
                        Integer lastNum = q.pollLast();
                        sb.append(lastNum).append('\n');
                    } else {
                        sb.append("-1").append('\n');
                    }
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                case "empty":
                    if(!q.isEmpty()){
                        sb.append(0).append('\n');
                    } else {
                        sb.append("1").append('\n');
                    }
                    break;
                case "front":
                    if(!q.isEmpty()){
                        sb.append(q.peekFirst()).append('\n');
                    } else {
                        sb.append("-1").append('\n');
                    }
                    break;
                case "back":
                    if(!q.isEmpty()){
                        sb.append(q.peekLast()).append('\n');
                    } else{
                        sb.append("-1").append('\n');
                    }
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
