package Programmers.chapter4.section4_1;

import java.util.Arrays;

/**
 * 자연수 뒤집어 배열로 만들기
 */
public class Problem5 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumber(12345)));
    }

    public static int[] printNumber(int n) {
        String str = Long.toString(n);
        String reverse = new StringBuilder(str).reverse().toString();
        char[] charArray = reverse.toCharArray();

        int[] result = new int[charArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = charArray[i] - '0';
        }

        return result;
    }
}
