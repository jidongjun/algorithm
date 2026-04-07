package Programmers;

public class Day12_공원산책 {
    public int[] solution(String[] park, String[] routes){
        int[] dh = {-1, 1, 0, 0};   // 위, 아래, 왼쪽, 오른쪽
        int[] dw = {0, 0, -1, 1};
        String[] dir = {"N","S","W","E"};

        int h = 0, w = 0;

        // 시작점 찾기
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    h = i;
                    w = j;
                }
            }
        }

        for (String r : routes) {
            String[] split = r.split(" ");
            String d = split[0];
            int dist = Integer.parseInt(split[1]);

            int idx = 0;
            for(int i = 0; i < 4; i++){
                if(dir[i].equals(d)){
                    idx = i;
                }
            }

            int nh = h;
            int nw = w;
            boolean canMove = false;

            for (int i = 0; i < dist; i++) {
                nh += dh[idx];
                nw += dw[idx];

                if (nh < 0 || nw < 0 || nh >= park.length || nw >= park[0].length()) {
                    canMove = false;
                    break;
                }

                if (park[nh].charAt(nw) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                h = nh;
                w = nw;
            }
        }

        return new int[]{h, w};
    }
}
