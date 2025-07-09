package inflearn;

import java.util.Scanner;

/**
 *  회중문자열 : 앞과 뒤가 똑같은 문자
 *  ex) Good
 *  len / 2 , len - i - 1 개념이 중요
 */
public class Problem7 {
    public String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for(int i = 0 ; i < len/2 ; i++){
            if(str.charAt(i) != str.charAt(len-i-1)){
                return "NO";
            }
        }
        return answer;
    }

    public String solution2(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        // equals는 대소문자를 구분
        if(str.equalsIgnoreCase(tmp)){
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem7 p = new Problem7();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        p.solution(str);
    }
}
