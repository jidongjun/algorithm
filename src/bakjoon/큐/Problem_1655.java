package bakjoon.큐;

import java.util.*;
import java.io.*;

public class Problem_1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());   // 큰 값을 뽑아내는 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();                             // 작은 값을 뽑아내는 힙

        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else{
                minHeap.offer(num);
            }

            // 힙 균형 맞추기
            if(maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if(maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
