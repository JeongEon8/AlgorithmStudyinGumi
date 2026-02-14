import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int idx = 666;
        int answer = 0;
        while(cnt < N) {
            if((idx+"").contains("666")) {
                cnt++;
            }
            if(cnt == N) answer = idx;
            idx++;
        }

        System.out.println(answer);

    }
}
