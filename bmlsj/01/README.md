# [백준 - 골드 5] 14567. 선수과목 (Prerequisite)

## ⏰**time**

60분

## :pushpin: **Algorithm**

위상정렬, BFS

## ⏲️**Time Complexity**

$O(N + M)$

## :round_pushpin: **Logic**

1. 각 과목의 진입차수(indegree)를 계산한다.
2. 진입차수가 0인 과목들을 큐에 넣고, 해당 과목의 수강 학기를 1로 설정한다.
3. 큐에서 과목을 하나씩 꺼내면서 연결된 다음 과목들의 진입차수를 감소시킨다.
4. 다음 과목의 학기는 `현재 과목 학기 + 1`과 `기존 값` 중 최댓값으로 갱신한다.
5. 진입차수가 0이 된 과목을 큐에 넣으며 과정을 반복한다.

```java
static void bfs(int[] indegree) {

     Queue<Integer> q = new ArrayDeque<Integer>();

     // 1. 진입 차수 0
     for (int i = 1; i <= N; i++) {
         if (indegree[i] == 0) {
             q.add(i);
             ans[i] = 1;
         }
     }

     // 연결 노드 진입 차수 감소
     while (!q.isEmpty()) {
         int cur = q.poll();

         for (int next : subjects[cur]) {
             indegree[next]--;

             ans[next] = Math.max(ans[next], ans[cur] + 1);
             if (indegree[next] == 0) {
                 q.add(next);
             }
         }
     }
}
```

## :black_nib: **Review**

## 📡 Link

<https://www.acmicpc.net/problem/14567>
