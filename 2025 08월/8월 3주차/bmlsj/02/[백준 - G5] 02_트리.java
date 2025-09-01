import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer>[] tree;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split(" ");

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        int root = -1;
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(split[i]);

            if (node != -1) {
                tree[node].add(i);
            } else {
                root = i;
            }
        }

        int remove = Integer.parseInt(br.readLine()); // 제거할 노드
        int leaf = 0;

        if (remove != root) {

            visited = new boolean[N];
            removeNode(remove);
            tree[remove].clear(); // 기존 모든 값 지우기
            tree[remove].add(-1); // -1 추가

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < tree[i].size(); j++) {
                    int num = tree[i].get(j);
                    if (num == remove) {
                        tree[i].remove(Integer.valueOf(num));
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (tree[i].size() == 0) {
                    leaf++;
                }
            }
        }

        System.out.println(leaf);

    }

    static boolean[] visited;

    static void removeNode(int remove) {

        if (!visited[remove]) {
            visited[remove] = true;
            for (int node : tree[remove]) {
                removeNode(node);
            }

            tree[remove].clear();
            tree[remove].add(-1);

        }

    }

}
