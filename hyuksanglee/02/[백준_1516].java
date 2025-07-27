package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1516 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] time = new int[N];        // 건물 자체를 짓는 데 걸리는 시간
        int[] result = new int[N];      // i번 건물까지 걸리는 최소 시간
        int[] inDegree = new int[N];    // 진입 차수
        List<Integer>[] graph = new ArrayList[N]; // 인접 리스트

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 입력 처리
        for (int i = 0; i < N; i++) {
            String[] input = in.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length - 1; j++) {
                int pre = Integer.parseInt(input[j]) - 1;
                graph[pre].add(i);  // pre → i
                inDegree[i]++;
            }
        }

        // 위상 정렬
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[i] = time[i]; // 선행 건물 없으면 자기 시간 그대로
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                result[next] = Math.max(result[next], result[cur] + time[next]);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}
