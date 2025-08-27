package bakjoon;

import java.util.Scanner;

public class Problem_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 첫번째 숫자 받기
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 두번째 배열 요소 입력
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // 세번째 세고싶은 수 입력
        int v = sc.nextInt();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == v){
                count++;
            }

            System.out.println(count);
        }
    }
}
