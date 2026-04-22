package Programmers;

public class Day17_둘만의암호 {

    public static void main(String[] args) {
        solution("aukks", "wbqd", 5);
    }

    public static String solution(String s, String skip, int index){
        StringBuilder valid = new StringBuilder();
        for(char c = 'a'; c <= 'z'; c++){
            if(skip.indexOf(c) == -1){
                valid.append(c);
            }
        }

        String validStr = valid.toString();
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            int pos = validStr.indexOf(c);
            // 넘친 만큼 다시 앞에서 시작
            int newPos = (pos + index) % validStr.length();

            answer.append(validStr.charAt(newPos));
        }

        return answer.toString();
    }
}
