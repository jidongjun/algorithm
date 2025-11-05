package bakjoon.투포인터;

import java.util.*;
import java.io.*;

public class Problem_1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 재료의 개수
        int M = Integer.parseInt(br.readLine());    // 갑옷을 만드는데 필요한 수

        int[] items = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items);

        int left = 0;
        int right = N-1;
        int count = 0;

        while(left < right){
            int item = items[left] + items[right];
            if(item == M){
                count++;
                left++;
                right--;
            } else if(item < M){
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
