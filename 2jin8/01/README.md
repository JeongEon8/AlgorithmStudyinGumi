# [백준- G2] 1766. 문제집
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
위상정렬

## ⏲️**Time Complexity**
$O((N+M)logN)$

## :round_pushpin: **Logic**
- 문제 간의 우선순위 존재 ⇒ 위상정렬
- 가능하면 쉬운 문제부터 == 번호가 작은 문제부터 ⇒ 우선순위 큐
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
for (int i = 1; i <= N; i++) {
  // 진입 차수가 0인 문제 번호 넣기
  if (degree[i] == 0) {
    pq.offer(i);
  }
}

StringBuilder sb = new StringBuilder();
while (!pq.isEmpty()) {
  int now = pq.poll();
  sb.append(now).append(" ");
  
  for (int next : graph[now]) {
    if (--degree[next] == 0) { // 진입차수 1개씩 줄이기 & 0이되면 큐에 넣기
      pq.offer(next);
    }
  }
}
```

## :black_nib: **Review**
잘못된 반례 생각하면서 쓸데없이 복잡하게 풀었다..

## 📡**Link**
- https://www.acmicpc.net/problem/1766
