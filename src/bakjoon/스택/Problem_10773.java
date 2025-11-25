package bakjoon.스택;

import java.util.*;
import java.io.*;

public class Problem_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Stack<Integer> stack = new Stack<>(); 도 가능함
        // 0이 아닐 경우 => push
        // 0일 경우 => pop
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(br.readLine());
            if (number != 0) {
                list.add(number);
            } else if(number == 0 && list.size() != 0){
                list.remove(list.size() - 1);
            }
        }

        int sum = 0;
        for(int num : list){
            sum += num;
        }

        System.out.println(sum);
    }
}
