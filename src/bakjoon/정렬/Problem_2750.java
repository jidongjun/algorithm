package bakjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem_2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);
        arr.forEach(System.out::println);
    }
}
