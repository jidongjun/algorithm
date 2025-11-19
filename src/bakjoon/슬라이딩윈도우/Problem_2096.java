package bakjoon.슬라이딩윈도우;

import java.util.*;
import java.io.*;

public class Problem_2096 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            maxDp[i] = num;
            minDp[i] = num;
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int newMax1 = Math.max(maxDp[0], maxDp[1])+ a;
            int newMax2 = Math.max(Math.max(maxDp[1], maxDp[2]), maxDp[3])+ b;
            int newMax3 = Math.max(maxDp[2], maxDp[3])+ c;

            int newMin1 = Math.min(minDp[0], maxDp[1])+ b;
            int newMin2 = Math.min(Math.min(maxDp[1], maxDp[2]), maxDp[3])+ b;
            int newMin3 = Math.min(maxDp[2], maxDp[3])+ c;


            maxDp[0] = newMax1;
            maxDp[1] = newMax2;
            maxDp[2] = newMax3;

            minDp[0] = newMin1;
            minDp[1] = newMin2;
            minDp[2] = newMin3;
        }

        int max = Math.max(Math.max(maxDp[0],maxDp[1]), maxDp[2]);
        int min =  Math.min(Math.min(minDp[0],minDp[1]), minDp[2]);

        System.out.println(max + "  " + min);
    }
}
