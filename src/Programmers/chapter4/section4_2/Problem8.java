package Programmers.chapter4.section4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. 1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하며 반복
 * 2. 설정된 길이만큼 문자열을 잘라 낸 token의 배열 생성
 * 3. 문자열을 비교하여 token의 배열을 하나의 문자열로 압축
 * 4. 1~3 과정으로 압축된 문자열 중 가장 짧은 길이 반환
 */
public class Problem8 {
    private List<String> split(String source, int length){
        List<String> tokens = new ArrayList<>();
        for(int startIndex = 0; startIndex < source.length(); startIndex += length){
            int endIndex = startIndex + length;
            if(endIndex > source.length()){
                endIndex = source.length();
            }
            tokens.add(source.substring(startIndex, endIndex));
        }

        return tokens;
    }

    /**
     * 문자열을 압축하고, 압축된 문자열의 길이를 반환
     */
    private int compress(String source, int length){
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 0;
        for(String token : split(source, length)) {
            if(token.equals(last)) {
                count++;
            } else {
                if(count > 1) builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if(count > 1) builder.append(count);
        builder.append(last);

        return builder.length();
    }

    // 1. 1부터 입력 문자열 s의 길미만큼 문자열의 길이를 생각하면 반곡
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for(int length = 1; length < s.length(); length++) {
            int compressed = compress(s, length);
            if(compressed < min) {
                min = compressed;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        Problem8 p = new Problem8();
        System.out.println(p.solution("aabbaccc"));
    }
}

