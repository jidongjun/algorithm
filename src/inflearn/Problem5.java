package inflearn;

import java.util.Scanner;

public class Problem5 {
    public String solution(String S) {
        String answer;
        char[] charArray = S.toCharArray();
        int lt = 0 , rt = charArray.length - 1;
        while (lt < rt) {
            if(!Character.isAlphabetic(charArray[lt])){
                lt++;
            } else if(!Character.isAlphabetic(charArray[rt])){
                rt--;
            } else {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;                   // TODO:: 잊지말고 처리해줄 것
                rt--;
            }
        }

        answer = String.valueOf(charArray);
        return answer;
    }

    public static void main(String[] args) {
        Problem5 p = new Problem5();
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        System.out.println(p.solution(S));
    }
}
