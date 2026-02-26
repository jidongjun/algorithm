package Programmers;

public class 유연근무제 {

    public int solution(int[] schedules, int[][] timelogs, int startDay) {
        int n = schedules.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int startHour = schedules[i] / 100;
            int startMinute = schedules[i] % 100;
            int startTime = startHour * 60 + startMinute;

            int deadLine = startTime + 10;

            boolean success = true;

            for (int j = 0; j < 7; j++) {
                int dayOfWeek = (startDay + j - 1) % 7;

                // 토(5), 일(6) 제외
                if (dayOfWeek == 5 || dayOfWeek == 6) {
                    continue;
                }

                int hour = timelogs[i][j] / 100;
                int minute = timelogs[i][j] % 100;
                int actualTime = hour * 60 + minute;

                if (actualTime > deadLine) {
                    success = false;
                    break;
                }
            }

            if (success) {
                answer++;
            }
        }

        return answer;
    }
}
