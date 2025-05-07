package Programmers.chapter4.section4_2_2;

import java.util.Arrays;

/**
 * 진법 바꾸기
 * Integer.parseInt(String s, int radix)    > radix 진법으로 숫자를 표현하는 문자열 s를 정수로 반환
 * Integer.toString(int v, int radix)       > 정수 v를 radix 진법의 문자열로 변환
 * Long.parseLong(String s, int radix)      > radix 진법으로 숫자를 표현하는 문자열 s를 정수로 변환
 * Long.toString(int v, int radix)          > 정수 v를 radix 진법의 문자열로 변환
 */

/**
 * 자연수 N 을 3진법상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return
 */
public class Problem9 {
    public int solution(int N) {
        String strThree = Integer.toString(N, 3);
        String reverseStr = new StringBuilder(strThree).reverse().toString();
        return Integer.valueOf(reverseStr, 3);
    }
}
