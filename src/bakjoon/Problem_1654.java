package bakjoon;

import java.util.*;
import java.io.*;

/**
 * 초기: [left ........ mid ........ right]
 *
 * (1) total >= N  → 충분 → 더 긴 길이를 탐색
 *      → mid 이하 구간은 볼 필요 없음
 *      → left = mid + 1
 *      결과: [mid+1 ....... right]
 *
 * (2) total < N  → 부족 → 더 짧은 길이를 탐색
 *      → mid 이상 구간은 볼 필요 없음
 *      → right = mid - 1
 *      결과: [left ....... mid-1]
 */
public class Problem_1654 {
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long max = 0;

        for(int i = 0; i < K ; i++){
            arr[i] = Long.parseLong(br.readLine());
            if(arr[i] > max) max = arr[i];
        }

        long left = 1;
        long right = max;
        long result = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;

            for(long num : arr){
                count += num / mid;
            }

            System.out.printf("left=%d, right=%d, mid=%d, total=%d%n", left, right, mid, count);

            if(count <= N ){        // 만들수 있는 랜선의 갯수가 충분 또는 적으면
                result = mid;       // 일단 결과 저장
                left = mid + 1;     // 큰 값을 계속 탐색
            } else {
                right = mid - 1;    // 더 작은 값쪽을 계속 탐색
            }
        }

        System.out.println(result);
    }
}
