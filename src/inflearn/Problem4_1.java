package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 특정글자만 뒤집으라는 경우
 */
public class Problem4_1 {
    public ArrayList<String> solution(int n, String[] arrStr) {
        ArrayList<String> answer = new ArrayList<>();
        for(String str : arrStr){
            // toCharArray : 문자 배열화
            char[] s = str.toCharArray();
            int lt = 0, rt = s.length - 1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem4_1 p = new Problem4_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arrStr = new String[n];
        for (int i = 0; i < n; i++) {
            arrStr[i] = sc.next();
        }

        for(String s : p.solution(n, arrStr)) {
            System.out.println(s);
        }

    }
}
