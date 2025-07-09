package inflearn;

import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Problem8 p = new Problem8();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        p.solution(str);
    }

    private String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)){
            answer = "YES";
        }
        return  answer;
    }
}
