package bakjoon.그리디;

import java.util.*;
import java.io.*;

public class Problem_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 1;
        int sum = 0;
        int count = 0;

        while(true){
            if(sum + num > N) break;
            sum += num;
            num++;
            count++;
        }

        System.out.println(count);
    }

}
