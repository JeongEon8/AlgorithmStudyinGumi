import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i <= N; i++) {
            list.add(i);
        }

        int idx = 0;

        while(list.size() > 1) {
            idx = (idx + K-1) % list.size();
            sb.append(list.get(idx)).append(", ");
            list.remove(idx);
        }
        sb.append(list.get(0)).append(">");

        System.out.println(sb);
    }
}
