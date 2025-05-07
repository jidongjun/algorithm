package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * StringBuilder.reverse()
 */
public class Problem4 {
    public ArrayList<String> solution(int n, String[] arrStr) {
        ArrayList<String> answer = new ArrayList<String>();
        for(String x : arrStr){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }


    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arrStr = new String[n];
        for (int i = 0; i < n; i++) {
            arrStr[i] = scanner.next();
        }

        for(String x : problem4.solution(n, arrStr)){
            System.out.println(x);
        }
    }
}
