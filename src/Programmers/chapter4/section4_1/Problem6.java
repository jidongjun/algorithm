package Programmers.chapter4.section4_1;

/**
 * 시저암호
 * 1. 입력 문자열의 모든 문자에 대해 반복
 * A. 알파벳이 아닌 경우 문자를 그대로 이어 붙이기
 * B. 알파벳인 경우 n 만큼 이어 붙이기
 */
public class Problem6 {
    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        // c를 n 만큼 밀어 반환
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        // 알파벳은 a부터 z까지 있으므로 가능한 position은 0부터 ('Z' - 'A')까지
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }

    public String solution(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            stringBuilder.append(push(c, n));
        }
        return stringBuilder.toString();
    }
}
