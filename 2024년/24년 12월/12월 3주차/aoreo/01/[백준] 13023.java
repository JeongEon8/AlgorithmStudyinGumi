import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    static boolean[] visited;
    static ArrayList<Integer>[] relations;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 인원 수
        int M = Integer.parseInt(st.nextToken());

        relations = new ArrayList[N];

        visited = new boolean[N];
        answer = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(relations[a] == null) relations[a] = new ArrayList<>();
            if(relations[b] == null) relations[b] = new ArrayList<>();

            relations[a].add(b);
            relations[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if(answer == 0) dfs(1, i);
        }

        System.out.println(answer);
    }

    static void dfs(int depth, int cur) {
        if(depth == 5) {
            answer = 1;
            return;
        }
        visited[cur] = true;

        if(relations[cur] != null) {
            for (Integer to : relations[cur]) {
                if(visited[to] == false) {
                    dfs(depth+1, to);
                }
            }
        }

        visited[cur] = false;
    }
}
