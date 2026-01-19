package bakjoon.수열;

import java.util.*;
import java.io.*;

public class Problem_2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int layer = 1;
        int max = 1;

        while (N > max) {
            max += 6 * layer;
            layer++;
        }

        System.out.println(layer);
    }
}
