# [백준- G5] 2565. 전깃줄
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- 전깃줄이 꼬이지 않으려면 B에 연결된 전깃줄 번호가 증가하는 식으로 연결되어야 함
  - 따라서 최장증가수열을 구하면 됨
- 최장증가수열의 길이가 꼬이지 않게 연결할 수 있는 전깃줄의 개수 ⇒ `N - 연결 가능한 전깃줄의 개수`가 정답
```java
// 최장 증가 수열 구하기
int maxConnect = 0; // 겹치지 않게 연결하는 전깃줄의 수
dp[1] = 1;
for (int i = 2; i <= maxNum; i++) {
    if (arr[i] == INF) continue;

    dp[i] = 1; // 자기 자신
    for (int j = 1; j < i; j++) {
        // 현재 번호보다 작은 번호가 존재하면 갱신
        if (arr[i] > arr[j]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
    maxConnect = Math.max(maxConnect, dp[i]);
}
```

## :black_nib: **Review**
DP 오랜만에 푸니까 감을 잃었다.. 겨우 기억해서 풀었다.

## 📡**Link**
- https://www.acmicpc.net/problem/2565
