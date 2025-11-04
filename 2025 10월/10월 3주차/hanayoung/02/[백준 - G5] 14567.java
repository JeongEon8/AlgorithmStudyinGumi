import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import static java.util.Collections.emptyList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> degree = new HashMap<>();

        int[] answer = new int[N];

        for(int i = 0; i < N; i++) {
            answer[i] = 1;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);

            degree.put(to, degree.getOrDefault(to, 0) + 1);
            degree.putIfAbsent(from, 0);
        }

        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: degree.entrySet()) {
            if(entry.getValue() == 0) q.add(entry.getKey());
        }

        HashMap<Integer, Integer> level = new HashMap<>();
        while(q.size() > 0) {
            int cur = q.poll();
            int curLevel = level.getOrDefault(cur, 1);
            for(int next: graph.getOrDefault(cur, emptyList())) {
                degree.put(next, degree.get(next)-1);
                if(degree.get(next) == 0) {
                    q.add(next);
                    level.put(next, curLevel+1);
                    answer[next-1] = curLevel+1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int value: answer) {
            sb.append(value).append(" ");
        }

        System.out.println(sb);
    }
}
