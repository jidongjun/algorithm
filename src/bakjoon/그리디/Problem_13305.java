package bakjoon.그리디;

import java.util.*;
import java.io.*;

public class Problem_13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[n-1];

        for(int i = 0; i < n; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] price = new int[n];
        for(int j = 0; j <= n; j++){
            price[j]= Integer.parseInt(st.nextToken());
        }

        long minPrice = price[0];
        long totalCost = 0;

        for (int i = 0; i < n - 1; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }

            totalCost += minPrice * dist[i];
        }

        System.out.println(totalCost);
    }
}
