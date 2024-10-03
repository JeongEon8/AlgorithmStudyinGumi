# [백준 - G3] 2623. 음악프로그램
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
위상정렬

## :round_pushpin: **Logic**
- 아래 과정을 큐가 빌 때까지 반복하기
  - 진입 차수가 0인 정점들을 큐에 넣기
  - 자신과 연결된 정점 끊기
  - 이때 새로 진입 차수가 0이 된다면 큐에 넣기
- 큐가 비어서 끝났는데 탐색한 정점이 N개가 아니라면 사이클이 발생한 것
```java
static boolean sorting() {
  Queue<Integer> queue = new ArrayDeque<>();
  // 진입 차수가 0
  for (int i = 1; i <= N; i++) {
    if (degrees[i] == 0) {
      queue.offer(i);
    }
  }

  int idx = 0;
  while (!queue.isEmpty()) {
    int now = queue.poll(); // 진입 차수가 0인 것만 나옴
    order[idx++] = now;
    // 연결 끊기
    for (int next : graph[now]) {
      if (--degrees[next] == 0) { // 진입 차수가 0이 되면 큐에 넣기
        queue.offer(next);
      }
    }
  }
  // 저장된 값이 N개가 아니면 위상정렬 실패 (사이클)
  return idx == N ? true : false;
}
```

## :black_nib: **Review**
방향 그래프이고 순서를 정하는 것이라 위상 정렬을 사용해서 풀면 될 것이라 생각했다. 그리고 처음에 아무 생각없이 예제에 나오는 수만큼 반복문을 돌려서 틀렸었다 ㅎㅎ.. 

## 📡**Link**
- https://www.acmicpc.net/problem/2623
