package bakjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (true) {
            if (sum >= M) {
                if (sum == M) count++;
                System.out.printf("%-6d %-6d %-6d %-6d %-20s\n", left, right, sum, count, "sum>=M → left++");
                sum -= arr[left++];
            } else {
                if (right == N) break;
                System.out.printf("%-6d %-6d %-6d %-6d %-20s\n", left, right, sum, count, "sum<M → right++");
                sum += arr[right++];
            }
        }

        System.out.println(count);
    }
}
