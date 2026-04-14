package Programmers;

public class Day14_덧칠하기 {

    public int solution(int n, int m, int[] selection) {
        int count = 0;
        int painted = 0;

        for (int i = 0; i < selection.length; i++) {
            if (selection[i] > painted) {
                count++;

                painted = selection[i] + m - 1;
            }
        }

        return count;
    }

}
