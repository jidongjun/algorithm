package inflearn;

import java.util.Scanner;

/**
 * indexOf(String s)    : 파라마터 글자의 위치를 알려준다.
 * charAt(int i)        : 파라미터 위치의 글자가 어떤건지 찾는다.
 */
public class Problem6 {
    public String solution(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) {
                answer += String.valueOf(str.charAt(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem6 p = new Problem6();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(p.solution(str));
    }
}
