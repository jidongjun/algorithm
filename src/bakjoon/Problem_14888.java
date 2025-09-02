package bakjoon;

import java.util.*;
import java.io.*;

public class Problem_14888 {
    static int N;                                       // 첫번째 숫자의 갯수
    static int[] numbers;                               // 게산할 숫자의 배열
    static int[] operators = new int[4];                // 사칙연산을 담을 배열
    static int min = Integer.MIN_VALUE;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 첫번째 숫자 입력

        numbers = new int[N];                   // 뱌열의 범위 지정
        StringTokenizer st = new StringTokenizer(br.readLine());    // number안에 담을 숫자 입력
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());                    // operator안에 담을 숫자 입력
        for(int i = 0; i < 4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void dfs(int result , int index){
        if (index == N) { // 모든 숫자를 다 사용했으면
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) { // 연산자 남아 있으면
                operators[i]--; // 하나 사용

                switch (i) {
                    case 0: dfs(result + numbers[index], index + 1); break;
                    case 1: dfs(result - numbers[index], index + 1); break;
                    case 2: dfs(result * numbers[index], index + 1); break;
                    case 3: dfs(result / numbers[index], index + 1); break;
                }

                operators[i]++; // 백트래킹 (원상복구)
            }
        }
    }
}
