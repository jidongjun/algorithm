package bakjoon.백트레킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15652 {
    static int n,m;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1, 0);
    }

    static void dfs(int start, int depth){
        if(depth == m){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= n; i++){
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
