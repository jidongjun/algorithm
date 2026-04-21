package Programmers;

public class Day16_카드뭉치 {

    public String solution(String[] card1, String[] card2, String[] goals) {
        int i = 0;
        int j = 0;

        for (String goal : goals) {
            if (i < card1.length && card1[i].equals(goal)) {
                i++;
            } else if (j < card2.length && card2[j].equals(goal)) {
                j++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
