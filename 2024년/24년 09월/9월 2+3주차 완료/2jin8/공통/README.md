# [백준 - G5] 14567. 선수과목
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
위상정렬

## :round_pushpin: **Logic**
- 선수과목이 없는 과목을 우선 큐에 넣기
- 큐에 저장된 크기만큼 반복하기
  - 큐가 반복된 횟수가 이수할 수 있는 최소 학기수
```java
Queue<Integer> queue = new ArrayDeque<>();
for (int i = 1; i <= N; i++) {
  // 선수과목이 없으면 큐에 넣기
  if (inDegree[i] == 0) {
    queue.offer(i);
  }
}

int order = 1;
while (!queue.isEmpty()) {
  int size = queue.size();
  for (int i = 0; i < size; i++) {
    int now = queue.poll();
    orders[now] = order;

    // 현재 과목과 연결된 과목 끊기 (선수과목 수강했으므로)
    for (int next : graph[now]) {
      if (--inDegree[next] == 0) {
        queue.offer(next);
      }
    }
  }
  order++;
}
```

## :black_nib: **Review**
A형 시험에 나왔던 문제와 유사하게 나와서 쉽게 풀 수 있었다. 기존 위상정렬 문제와 달리 큐 사이즈만큼 반복을 해야 한다는 점이 달라서 좀 헷갈릴 수 있을 것 같다.

## 📡**Link**
- https://www.acmicpc.net/problem/14567
