# [백준 - G2] 12738. 가장 긴 증가하는 부분 수열 3
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
이분 탐색

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- `Arrays.binarySearch()` 메서드를 이용해서 현재 수가 들어갈 수 있는 인덱스 찾기
  - 만약 인덱스가 0 이하라면 `-1 * 인덱스 + 1`로 변환하기
- `배열[인덱스]` 값을 변경하기
- 배열에 들어가는 값은 중요하지 않음 (증가하는 부분 수열의 개수만 보는 것)
```java
int[] dp = new int[N];
Arrays.fill(dp, INF);
dp[0] = arr[0];
for (int i = 1; i < N; i++) {
  int idx = Arrays.binarySearch(dp, arr[i]);
  if (idx < 0) {
    idx = -1 * idx - 1;
  }
  dp[idx] = arr[i];
}

int len = 0;
for (int i = 0; i < N; i++) {
  if (dp[i] == INF)
    break;

  len++;
}
```

## :black_nib: **Review**
이때까지 LIS는 for문을 2번 사용하는 DP로만 풀었는데, 수업에서 이분 탐색을 사용하는 방법을 배워서 관련 문제를 풀어봤다.

## 📡**Link**
- https://www.acmicpc.net/problem/12738
