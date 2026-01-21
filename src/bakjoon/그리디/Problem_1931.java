package bakjoon.그리디;

import java.util.*;
import java.io.*;

public class Problem_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(meetings, (a, b) -> {
            if(a[1] == b[1]) {
                // 종료시간이 같으면 시작시간 비교
                // a가 더 빨리 시작 -> 음수 -> a먼저
                // b가 더 빨리 시작 -> 양수 -> b먼저
                return a[0] - b[0];
            } else {
                // 종료시간이 다르면
                // a가 더 빨리 끝남 -> 음수 -> a먼저
                // b가 더 빨리 끝남 -> 양수 -> b먼저
                return a[1] - b[1];
            }

        });

        int count = 0;
        int lastEnd = 0;
        for(int i = 0; i < N; i++){
            // 끝시간이 시작시간보다 작다
            if(meetings[i][0] >= lastEnd){
                count++;
                lastEnd = meetings[i][1];
            }
        }

        System.out.println(count);
    }
}
