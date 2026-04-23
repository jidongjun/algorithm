package Programmers;

public class Day18_크기가작은부분문자열 {

    public static void main(String[] args) {
        solution("500220839878", "7");
    }

    public static int solution(String t, String p){
        int answer = 0;
        int startIndex = 0;
        int endIndex = p.length();

        while(endIndex <= t.length()){
            String sub = t.substring(startIndex, endIndex);
            // 길이가 같은 문자열 비교로도 숫자비교가능
            if(sub.compareTo(p) <= 0){
                answer++;
            }

            startIndex++;
            endIndex++;
        }

        System.out.println(answer);

        return answer;
    }
}
