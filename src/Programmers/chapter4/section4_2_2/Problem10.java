package Programmers.chapter4.section4_2_2;

import java.util.Arrays;

/**
 * 1. 검사하는 문자열이 "1"이 될때까지 반복
 *
 */
public class Problem10 {

    public int[] solution(String str){
        int zeroCnt = 0;
        int chantCnt = 0;
        do{
            StringBuilder builder = new StringBuilder();
            char[] charArray = str.toCharArray();
            for(char c : charArray){
                if(c != '0'){
                    builder.append(c);
                } else {
                    zeroCnt++;
                }
            }

            int strLength = builder.toString().length();
            str = Integer.toString(strLength, 2);
            chantCnt++;
        }while(str.length() != 1);

        return new int[]{chantCnt, zeroCnt};
    }

    public int[] bookSolution(String s){
        int loop = 0;
        int removed = 0;
        while (!s.equals("1")){
            int zeors = countZeros(s);
            loop += 1;
            removed += zeors;

            int ones = s.length() - zeors;
            s = Integer.toString(ones, 2);
        }

        return new int[]{loop, removed};
    }

    private int countZeros(String s){
        int zeros = 0;
        for(char c: s.toCharArray()){
            if( c == '0') zeros++;
        }
        return zeros;
    }

    public static void main(String[] args) {
        Problem10 p = new Problem10();
        int[] solution = p.solution("1111111");
        System.out.println(Arrays.toString(solution));
    }
}
