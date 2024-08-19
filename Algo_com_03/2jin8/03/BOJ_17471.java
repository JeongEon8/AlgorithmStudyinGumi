import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {

    static final int MAX = 999_999;
    static int N, total, diff = MAX;
    static int[] people; // people: 각 구역 인구수를 저장하기 위한 배열
    static boolean[] areaInfo; // 선거구를 구분하기 위한 배열
    static ArrayList<Integer>[] graph; // 각 구역 연결 정보를 저장하기 위한 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 초기화
        people = new int[N + 1];
        areaInfo = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 각 구역의 인구 수 저장하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            total += people[i]; // 총 인구 수
        }

        // 각 구역의 연결 정보 저장하기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int connectArea = Integer.parseInt(st.nextToken()); // 연결된 구역 수
            for (int j = 0; j < connectArea; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 두 지역밖에 없으면 둘의 차이가 최소 인구 차이
        if (N == 2) {
            System.out.println(Math.abs(people[1] - people[2]));
            return;
        }

        // 한 선거구에 포함되는 지역의 개수를 1개 ~ N/2개로 설정하기
        // nCm = nCn-m
        for (int i = 1; i <= N / 2; i++) {
            dfs(0, i, 1, 0);
        }
        System.out.println(diff == MAX ? -1 : diff);
    }

    static void dfs(int depth, int area, int start, int sum) {
        // 한 선거구에 포함되는 지역을 다 고른 경우
        if (depth == area) {
            // 각 선거구가 연결되었는지 확인하기
            if (isConnected()) { // 연결되었으면 최소 차이값으로 갱신
                diff = Math.min(diff, Math.abs(2 * sum - total)); // sum - (total - sum)
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            areaInfo[i] = true;
            dfs(depth + 1, area, i + 1, sum + people[i]);
            areaInfo[i] = false;
        }
    }

    static boolean checkConnection(ArrayList<Integer> group) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(group.get(0));
        boolean[] visited = new boolean[N + 1];
        visited[group.get(0)] = true;

        int connectionArea = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            connectionArea++;

            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (group.contains(next) && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        // 연결된 지역의 수와 선거구에 포함된 지역의 수가 다르면 불가능한 방법
        if (connectionArea != group.size()) return false;
        return true;
    }

    static boolean isConnected() {
        ArrayList<Integer> group1 = new ArrayList<>();
        ArrayList<Integer> group2 = new ArrayList<>();

        // 각 선거구 정보 기록하기
        for (int i = 1; i <= N; i++) {
            if (areaInfo[i]) group1.add(i);
            else group2.add(i);
        }

        // 모든 선거구가 연결되어있는 경우
        if (checkConnection(group1) && checkConnection(group2))
            return true;

        return false;
    }
}
