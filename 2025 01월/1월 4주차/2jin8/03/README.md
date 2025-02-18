# [백준- S2] 14496. 그대, 그머가 되어
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N + M)$

## :round_pushpin: **Logic**
- 단순히 BFS 탐색해서 제일 빨리 A를 B로 만드는 횟수를 반환하면 됨
- 이때, a를 b로 치환 가능하면 b도 a로 치환 가능함
  - 따라서 양방향임!
```java
for (int i = 0; i < M; i++) {
  st = new StringTokenizer(br.readLine());
  int a = Integer.parseInt(st.nextToken());
  int b = Integer.parseInt(st.nextToken());
  graph[a].add(b);
  graph[b].add(a);
}
```

## :black_nib: **Review**
처음에 단방향인줄 알았는데 두 번째 예시를 보니 양방향이었다. 잘 확인하자

## 📡**Link**
- https://www.acmicpc.net/problem/14496
