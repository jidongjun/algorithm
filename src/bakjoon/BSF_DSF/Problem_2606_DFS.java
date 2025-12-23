package bakjoon.BSF_DSF;

import java.io.*;
import java.util.*;

public class Problem_2606_DFS {
    static int computerCnt;     // 컴퓨터의 수
    static int connectedLine;   // 연결되어있는 컴퓨터 쌍의 수

    static ArrayList<Integer>[] networkMap;
    static boolean[] visited;

    static StringTokenizer st;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerCnt = Integer.parseInt(br.readLine());
        connectedLine = Integer.parseInt(br.readLine());

        networkMap = new ArrayList[computerCnt+1];      // 1부터 시작하기 때문에
        visited = new boolean[computerCnt+1];

        for(int i = 1; i < computerCnt+1; i++){
            networkMap[i] = new ArrayList<>();
        }

        for(int i = 0; i < connectedLine; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            networkMap[a].add(b);
            networkMap[b].add(a);
        }

        dfs(1);
        System.out.println(count -1 ); // 자기자신은 제외
    }


    static void dfs(int start){
        visited[start] = true;
        count++;

        for(int next :  networkMap[start]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

}
