package Programmers;

import java.util.Arrays;

public class 공원 {

    public int solution(int[] mats, int[][] park) {
        int answer = 0;

        // 가장 큰 매트부터 크기 정렬
        Arrays.sort(mats);

        int n = park.length;
        int m = park[0].length;

        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];

            for (int r = 0; r <= n - size; r++) {
                for (int c = 0; c <= m - size; c++) {
                    boolean can = true;

                    for (int x = r; x < r + size; x++) {
                        for (int y = c; y < y + size; y++) {
                            if (park[x][y] != -1) {
                                can = false;
                                break;
                            }
                        }
                        if (!can) {
                            break;
                        }
                    }
                    if (can) {
                        return size;
                    }
                }
            }
        }

        return -1;
    }
}
