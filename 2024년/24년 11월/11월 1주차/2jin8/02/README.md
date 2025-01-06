# [백준- G4] 11054. 가장 긴 바이토닉 부분 수열
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
- 증가하는 가장 긴 부분 수열의 길이(왼 → 오), 감소하는 가장 긴 부분 수열의 길이(오 → 왼) 구하기
- 바이토닉 수열은 `A < B < C > D > E`의 특징을 가짐
  - 따라서 두 DP 배열의 값을 합친 것이 바이토닉 부분 수열의 길이
    - i번째 수가 C의 위치에 해당하는 것
  - 이때, i번째 수를 중복으로 세므로, 1을 빼줘야 함
```java
// 왼쪽 > 오른쪽
int[] dp = new int[N];
for (int i = 0; i < N; i++) {
  dp[i] = 1;
  for (int j = 0; j < i; j++) {
    if (arr[j] < arr[i]) {
      dp[i] = Math.max(dp[i], dp[j] + 1);
    }
  }
}

// 오른쪽 > 왼쪽
int[] rdp = new int[N];
for (int i = N - 1; i >= 0; i--) {
  rdp[i] = 1;
  for (int j = N - 1; j > i; j--) {
    if (arr[j] < arr[i]) {
      rdp[i] = Math.max(rdp[i], rdp[j] + 1);
    }
  }
}

int maxLen = 0;
for (int i = 0; i < N; i++) { // 두 dp 배열의 값을 더하기 = 바이토닉 수열의 길이
  dp[i] += rdp[i] - 1; // i번째 수를 중복으로 셌으므로 1을 빼야 함
  maxLen = Math.max(maxLen, dp[i]);
}
```

## :black_nib: **Review**
증가/감소하는 가장 긴 부분 수열의 길이를 구해놓고 바이토닉 부분 수열의 길이를 어떻게 구할지 몰라 노가다 식으로 풀었는데 그냥 두 배열을 합치면 된다는 것을 알았음..ㅎ

## 📡**Link**
- https://www.acmicpc.net/problem/11054
