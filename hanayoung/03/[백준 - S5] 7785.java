import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        Map<String, Boolean> enter = new HashMap<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            if("enter".equals(st.nextToken())) {
                enter.put(name, true);
            } else {
                enter.remove(name);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(String name: enter.keySet()) {
            pq.add(name);
        }

        while(pq.size() > 0) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
