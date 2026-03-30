import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, String> pwdMap = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pwdMap.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            sb.append(pwdMap.get(st.nextToken())).append("\n");
        }

        System.out.println(sb);
    }
}
