package bakjoon.스택;

import java.io.*;
import java.util.*;

public class Problem_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            int count = 0;
            boolean isValid = true;

            for(char c : line.toCharArray()){
                if( c == '('){
                    count++;
                } else {
                    count--;
                    if(count < 0){
                        isValid = false;
                        break;
                    }
                }
            }

            if(count != 0){
                isValid = false;
            }

            sb.append(isValid ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
