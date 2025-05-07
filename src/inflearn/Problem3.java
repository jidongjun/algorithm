package inflearn;

import java.util.Scanner;

public class Problem3 {
    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m){
                m  = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        // 마지막단어 처리
        if(str.length() > m){   answer = str;}
        return answer;
    }

    public static void main(String[] args) {
        Problem3 p = new Problem3();
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        System.out.println(p.solution(N));
    }
}
