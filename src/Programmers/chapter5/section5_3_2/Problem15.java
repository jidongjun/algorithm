package Programmers.chapter5.section5_3_2;

// 상태 : (offsetX, offsetY, size) : 좌표 (offSetX, offSetY)에서 시작하여 가로길이와 세로길이가
// size인 정사각형을 압축 했을 때 남아있는 0과 1의 수
public class Problem15 {
    private static class Count {
        private final int zero;
        private final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }

        private Count count(int offsetX, int offsetY, int size, int[][] arr) {
            int h = size / 2;
            for (int x = offsetX; x < offsetX + size; x++) {
                for (int y = offsetY; y < offsetY + size; y++) {
                    if (arr[y][x] != arr[offsetY][x]) {
                        return count(offsetX, offsetY, h, arr)  // 각 영역에 대한 시작점 카운트
                                .add(count(offsetX + h, offsetY, h, arr))
                                .add(count(offsetX, offsetY + h, h, arr))
                                .add(count(offsetX + h, offsetY + h, h, arr));
                    }
                }
            }


            if (arr[offsetY][offsetX] == 1) {
                return new Count(0, 1);
            }

            return new Count(1, 0);
        }

        public int[] solution(int[][] arr) {
            Count count = count(0, 0, arr.length, arr);
            return new int[]{count.zero, count.one};
        }
    }
}
