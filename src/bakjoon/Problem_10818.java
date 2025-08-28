package bakjoon;

import java.io.*;
import java.util.*;

/**
 * 입력값
 * 5
 * 20 10 35 30 7
 */
public class Problem_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num < min) min = num;
            if(num > max) max = num;
        }

        System.out.println(max - min);
    }
}
