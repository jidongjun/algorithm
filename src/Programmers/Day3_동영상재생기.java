package Programmers;

public class Day3_동영상재생기 {

    /**
     *
     * @param video_len : 동영상의 길이
     * @param pos       : 기능이 수행되기 직전의 재생위치
     * @param op_start  : 오프닝 시작 시각
     * @param op_end    : 오프닝이 끝나는 시각
     * @param commands  : 사용자 입력을 나타내는 문자열 배열
     * @return
     */
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands){
        String answer = "";

        int videoLen   = toSeconds(video_len);
        int position   = toSeconds(pos);
        int opStart    = toSeconds(op_start);
        int opEnd      = toSeconds(op_end);

        // 오프닝 시간을 판단해서 오프닝 건너뛰기 여부 결정
        if(opStart <= position && position <= opEnd){
            position = opEnd;
        }

        for(String cmd : commands){
            if(cmd.equals("prev")){
                position = Math.max(0, position - 10);
            } else {
                position = Math.min(videoLen, position + 10);
            }

            // 매번 오프닝 체크
            if(opStart <= position && position <= opEnd){
                position = opEnd;
            }
        }

        return toTime(position);
    }

    /**
     * 문자열 시간을 초로 변환해주는 메서드
     * @param time
     * @return
     */
    private int toSeconds(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    /**
     * 초로 변환한 시간을 다시 문자열로 변환해주는 메서드
     * @param sec
     * @return
     */
    private String toTime(int sec){
        int m = sec % 60;
        int s = sec / 60;

        return String.format("%02d:%02d", m, s);
    }
}
