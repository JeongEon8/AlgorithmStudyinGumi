# [백준- G4] 2110. 공유기 설치
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
이분 탐색

## ⏲️**Time Complexity**
$O(nlogn)$

## :round_pushpin: **Logic**
- 가장 인접한 두 공유기 사이의 거리를 기준으로 두기
  - 1 ~ 가장 멀리 위치한 공유기의 x 좌표
- 공유기를 C개 이상 설치할 수 있는 경우
  - 인접한 두 공유기 사이 늘리기
- 설치할 수 없다면 공유기 사이 좁히기
```java
static int findMaxDistance(int max) {
  int left = 1, right = max;
  int ans = 0;

  while (left <= right) {
    int mid = (left + right) / 2;

    // 공유기를 C개 이상 설치할 수 있는 경우
    // 인접한 두 공유기 사이의 거리를 늘려보기
    // => 우측으로
    if (check(mid)) {
      ans = mid;
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return ans;
}
```

## :black_nib: **Review**
유사한 이분 탐색 문제를 풀어서인지 비교적 빠르게 풀이가 떠올랐다. 많이 풀어보는 것이 답인 듯!

## 📡**Link**
- https://www.acmicpc.net/problem/2110
