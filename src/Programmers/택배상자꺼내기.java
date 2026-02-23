package Programmers;

/**
 * row = (num - 1) / w
 * pos = (num - 1) % w
 * 홀수줄이면 뒤집기
 */
public class 택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        int answer = 0;

        // num이 몇번째 줄
        int row = (num-1) / w;

        // num이 자기 줄에서 왼쪽 기준 몇 번째인지
        int pos = (num - 1) % w;

        // 실제 세로 위치 구하기
        int column;

        if(row % 2 == 0){
            // 정방향 줄이면 그대로
            column = pos;
        } else {
            column = w - 1 - pos;
        }

        // 전체 줄 개수
        int totalRows = (n + w - 1) / w ;

        for(int r = row; r < totalRows; r++){
            int boxNumber;

            if(r % 2 == 0){
                boxNumber = r * w + column + 1;
            } else {
                // 역방향 줄
                boxNumber = r * w + (w - 1 - column) + 1;
            }

            // 실제 존재하는 상자면 카운트
            if (boxNumber <= n) {
                answer++;
            }
        }

        return answer;
    }
}
