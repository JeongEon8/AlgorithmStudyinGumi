# [백준 - G3️] 1005. ACM Craft
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
위상정렬 (+ DP)

## :round_pushpin: **Logic**
- 진입차수가 0인 건물 큐에 넣기 & 건물이 세워지는 시간 기록
- 큐가 빌 때까지 다음 과정 반복
  - 큐에서 하나 빼기
    - 만약 해당 건물이 목표 건물이라면 break
  - 해당 건물과 연결된 건물 사이 간선 끊기
    - 현재 건물과 연결된 건물을 짓는데 걸리는 시간 구하기
    - 진입차수가 0이 되면 큐에 넣기
```java
Queue<Integer> queue = new ArrayDeque<>();
for (int i = 1; i <= N; i++) {
  // 진입 차수가 0인 건물 큐에 넣기
  if (inDegree[i] == 0) {
    queue.offer(i);
    delay[i] = times[i];
  }
}

while (!queue.isEmpty()) {
  int now = queue.poll();
  if (now == target)
    break;

  for (int next : graph[now]) {
    // next 건물을 짓기 전까지 소요되는 최대 시간 구하기
    // 선수 건물들이 다 지어질 때까지 기다려야 하므로 최대 시간을 구해야 함
    delay[next] = Math.max(delay[next], delay[now] + times[next]);

    // 진입차수가 0이 되면 큐에 넣기
    if (--inDegree[next] == 0) {
      queue.offer(next);
    }
  }
}
```

## :black_nib: **Review**
단순하게 위상정렬을 하면 되는 줄 알고 코드를 작성했다가 틀렸다.(반례가 너무 많은 코드였다..) 약간 DP적인 부분이 포함되어서 위상정렬과 DP 둘 다 연습하기 좋았던 문제라고 생각한다.

## 📡**Link**
- https://www.acmicpc.net/problem/1005
