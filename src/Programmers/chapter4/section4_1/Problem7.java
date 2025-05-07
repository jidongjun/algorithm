package Programmers.chapter4.section4_1;

// 문자열 s > 한 개 이상의 단어로 구성
// 각 단어는 하나 이상의 공백 문자로 구성
// 각 단어의 짝수 번쨰 알파벳은 대문자로
// 각 단어의 홀수 번째 알파벳은 소문자로 바꾼 문자열을 return
public class Problem7 {
    /**
     * 문제 풀이 흐름
     * 1. 문자열의 모든 문자에 대해 반복
     *  A. 문자가 공백문자 일 경우
     *      i. 그대로 이어붙이기
     *      ii. 다음 등장하는 알파벳은 대문자
     *  B. 문자가 공백문자가 아닐 경우
     *      i. 대, 소문자 변환하여 이어 붙이기
     *      ii. 다음 등장하는 알파벳의 대.소문자는 현재 변환하는 문자와 반대
     * 2. 구성한 문자열을 반환
     */
    public String getAnswer(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean toUpper = true;

        for (char c : value.toCharArray()) {
            if (!Character.isAlphabetic(c)) { // 공백문자 일 경우
                stringBuilder.append(c);
                toUpper = true;
            } else {
                if (toUpper) {
                    stringBuilder.append(Character.toUpperCase(c));
                } else {
                    stringBuilder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        System.out.println(problem7.getAnswer("try to world"));
    }
}
