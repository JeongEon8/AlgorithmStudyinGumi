import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        List<Integer>[] tree = new ArrayList[N];
        int[] parents = new int[N];

        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent > -1) {
                tree[parent].add(i);
            }
            parents[i] = parent;
        }
        st = new StringTokenizer(bf.readLine());
        int removeNode = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(removeNode);
        if(parents[removeNode] > -1) tree[parents[removeNode]].remove(Integer.valueOf(removeNode)); // 삭제할 노드가 루트가 아닌 경우

        while(q.size() > 0) {
            int node = q.poll();
            if(tree[node] != null) {
                for(int next: tree[node]) {
                    q.add(next);
                }
            }
            tree[node] = null;
        }

        for(int i = 0; i < N; i++) {
            if(tree[i] != null && tree[i].size() == 0) answer++;
        }

        System.out.println(answer);
    }
}
