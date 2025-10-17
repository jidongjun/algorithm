package bakjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] requests = new int[N];
        int max = 0;
        int min = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            if (requests[i] > max) {
                max = requests[i];
            }
            if (requests[i] < min) {
                min = requests[i];
            }
        }

        int totalBudget = Integer.parseInt(br.readLine());  //  각 예산의 합계
        int solution = 0;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int budgetSum = 0;
            /*for (int i = 0; i < N; i++) {
                if (requests[i] > mid) {
                    budgetSum += mid;
                } else {
                    budgetSum += requests[i];
                }
            }*/

            for (int num : requests) {
                budgetSum += Math.min(num, mid);
            }

            // mid를 기준으로 범위 줄이기
            if (budgetSum <= totalBudget) {
                solution = mid;
                min = mid + 1;          
            } else {
                max = mid - 1;
            }
        }

        System.out.println(solution);
    }
}
