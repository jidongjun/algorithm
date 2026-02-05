package bakjoon.백트레킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15650 {

    private static int n, m;
    private static int[] arr;              // 숫자를 담는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1, 0);
    }


    // start : 다음에 선택 가능한 최소 숫자
    // depth : 현재 몇 개 뽑았는지
    static void dfs(int start, int depth) {
        if(depth == m){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= n; i++){
            arr[depth] = i;
            dfs(start + 1, depth + 1);
        }
    }
}
