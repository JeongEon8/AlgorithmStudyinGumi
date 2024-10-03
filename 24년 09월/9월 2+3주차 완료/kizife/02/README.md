# [백준] 5014. 스타트링크
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
너비 우선 탐색

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
```java
while (!queue.isEmpty()) {
  int now = queue.poll(); // 현재 층을 큐에서 꺼냄

  if (now == g) { // 목표 층에 도달했으면
    System.out.println(arr[now]); // 클릭 수 출력
    return; // 메서드 종료
  }

  for (int i = 0; i < 2; i++) { // 올라가거나 내려가는 버튼을 눌러보기
    int next = now + button[i]; // 다음 층 계산

    // 층이 유효한지 검사
    if (next < 1 || next > f)
      continue; // 유효하지 않으면 다음으로

    // 아직 방문하지 않은 층이라면
    if (!visit[next]) {
      visit[next] = true; // 방문 처리
      queue.add(next); // 큐에 추가
      arr[next] = arr[now] + 1; // 버튼 클릭 수 업데이트
    }
  }
}
```


## :black_nib: **Review**
- 나는 그냥 dfs가 좋다... 

## 📡**Link**
- https://www.acmicpc.net/problem/5014
