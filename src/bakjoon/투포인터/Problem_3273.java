package bakjoon.투포인터;

import java.util.*;
import java.io.*;

public class Problem_3273 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자의 갯수
        int n = Integer.parseInt(br.readLine());

        // 숫자들
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        // 합 해서 나와야 하는 수
        int x =  Integer.parseInt(br.readLine());

        int left = 0;
        int right = n-1;
        int count = 0;

        while(left < right){
            int sum =  nums[left] + nums[right];
            if(sum < x){
                left++;
            } else if(sum > x){
                right--;
            } else {
                count++;
                left++;
                right--;
            }

        }

        System.out.println(count);
    }
}
