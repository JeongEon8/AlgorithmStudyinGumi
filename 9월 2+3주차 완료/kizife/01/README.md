# [백준] 2644. 촌수계산 
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
그래프 탐색 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
```java
for (int next : list.get(now)) { // 현재 노드의 모든 인접 노드에 대해 반복
  if (!visit[next]) {
    arr[next] = arr[now] + 1; // 인접 노드의 거리를 현재 노드의 거리 + 1로 설정
    if (next == end) // 인접 노드가 목표 노드인 경우, 거리 반환
      return arr[next];
    queue.offer(next); // 인접 노드를 큐에 추가
    visit[next] = true; // 인접 노드를 방문한 것으로 표시
  }
}
```


## :black_nib: **Review**
- 나는 그냥 2차원 배열이 좋다... 

## 📡**Link**
- https://www.acmicpc.net/problem/2644
