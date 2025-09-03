package bakjoon;

import java.util.*;
import java.io.*;

public class Problem_2562 {
    public static void main(String[] args) throws IOException {
        int max = Integer.MIN_VALUE;
        int line = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > max) {
                max = num;
                line = i+1;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n" + line);

        bw.flush();
    }
}
