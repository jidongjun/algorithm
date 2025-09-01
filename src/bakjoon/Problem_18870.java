package bakjoon;

import java.io.*;
import java.util.*;

public class Problem_18870{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] sorted =  new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] =  sorted[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 + 중복제거
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int num : sorted){
            if(!map.containsKey(num)){
                map.put(num, rank++);
            }
        }

        for(int i = 0; i < N; i++){
            bw.write(map.get(arr[i]) + " ");
        }

        bw.flush();
        bw.close();
    }
}
