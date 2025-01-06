# [백준 - S4] 2003. 수들의 합 2
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
완전탐색

## :round_pushpin: **Logic**
- 각 인덱스까지의 합을 더해서 기록하기
- 시작 인덱스와 종료 인덱스를 하나씩 다 정한 뒤 M이 될 때마다 더하기
```java
for (int i = 1; i <= N; i++) {
  arr[i] = Integer.parseInt(st.nextToken());
  dp[i] = arr[i] + dp[i - 1];
}

for (int i = 1; i <= N; i++) {
  for (int j = i; j <= N; j++) {
    int sum = dp[j] - dp[i - 1];
    if (sum == M)
      cnt++;
  }
}
```

## :black_nib: **Review**
처음에 어떻게 풀어야하나.. 싶어서 조금 당황했었다.. 

## 📡**Link**
- https://www.acmicpc.net/problem/2003
