package Programmers.chapter4.section4_2_3;

public class Problem11 {

    public boolean solution(String s){
        char[] charArray = s.toCharArray();
        int pCount = 0;
        int yCount = 0;
        for(char c: charArray){
            if(c == 'p' || c == 'P'){
                pCount++;
            } else if(c == 'y' || c == 'Y'){
                yCount++;
            }
        }

        if(pCount == yCount){
            return true;
        } else if(pCount != yCount){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Problem11 p = new Problem11();
        System.out.println(p.solution("qwerrqweqwe"));
    }
}
