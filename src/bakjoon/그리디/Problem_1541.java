package bakjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        // -를 기준으로 식을 분리
        String[] minusSplit = line.split("-");

        // -를 기준으로 분리된 그룹의 시작항목을 계산
        int result = sumOfGroup(minusSplit[0]);

        // 계산된 결과값에서 나머지 항목들을 빼준다.
        for (int i = 1; i < minusSplit.length; i++) {
            result -= sumOfGroup(minusSplit[i]);
        }

        System.out.println(result);
    }

    public static int sumOfGroup(String part) {
        String[] num = part.split("\\+");
        int sum = 0;
        for (String n : num) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }
}
