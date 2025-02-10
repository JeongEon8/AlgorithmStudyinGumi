import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1]; //진입차수 
        int[] semester = new int[n + 1]; //최소학기수 

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            inDegree[b]++; 
        }

        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수가 0인 노드(즉 선수 과목 없는 과목) -> 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                semester[i] = 1; //첫학기에 수강가능
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                inDegree[next]--; // 선수과목 이수 완 
                if (inDegree[next] == 0) {
                    queue.add(next);
                    semester[next] = semester[now] + 1; // 다음 학기는 현재 학기 + 1
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(semester[i] + " ");
        }
    }
}
