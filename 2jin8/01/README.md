# [백준- G4] 13424. 비밀 모임
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
플로이드 와셜

## ⏲️**Time Complexity**
$O(N³)$

## :round_pushpin: **Logic**
- `출발지 → 도착지` vs `출발지 → 경유지 → 도착지`
  - 둘 중 작은 거리로 갱신
```java
// 출발지 -> 도착지 거리 구하기
for (int k = 1; k <= N; k++) {
  for (int i = 1; i <= N; i++) { // 출발
    for (int j = 1; j <= N; j++) { // 도착
      dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
    }
  }
}

// 모임에 참여하는 친구들
K = Integer.parseInt(br.readLine());
st = new StringTokenizer(br.readLine());
people = new int[K];
for (int i = 0; i < K; i++) {
  people[i] = Integer.parseInt(st.nextToken());
}

int minTotal = INF, minIdx = 0;
for (int i = 1; i <= N; i++) {
  int total = 0;
  for (int person : people) {
    total += dist[person][i];
  }

  if (minTotal > total) {
    minTotal = total;
    minIdx = i;
  }
}
```

## :black_nib: **Review**
플로이드 와셜 엄청 오랜만이라 까먹었다. 여러 유형 꾸준히 풀어봐야지..

## 📡**Link**
- https://www.acmicpc.net/problem/13424
