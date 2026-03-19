package Programmers;

public class 이웃한_칸 {
    public int solution(String[][] board, int h, int w){
        int answer = 0;

        int boardSize = board.length;

        int[] dy = {-1,1,0,0};
        int[] dw = {0,0,-1,1};

        for(int i = 0; i < 4; i++){
            int ny = h + dy[i];
            int nx = w + dw[i];

            if(nx >= 0 && nx < boardSize && ny >= 0 && ny < boardSize){
                if(board[ny][nx].equals(board[h][w])){
                    answer++;
                }
            }
        }

        return answer;
    }
}
