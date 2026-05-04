# [프로그래머스 - Lv2] 완전범죄

## ⏰**time**

36분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍 (DP)
- 배낭 문제 응용

## ⏲️**Time Complexity**

$O(K \times m)$  
(\(K\): 물건 개수 = `info.length`)

## :round_pushpin: **Logic**

1. `dp[j]`를 **B 도둑 흔적 합이 `j`일 때 가능한 A 도둑 흔적의 최소값**으로 정의합니다.  
   초기에는 아무 물건도 훔치지 않았으므로 `dp[0] = 0`, 나머지는 불가능 상태(`INF`)로 둡니다.

```java
int[] dp = new int[m];
Arrays.fill(dp, INF);
dp[0] = 0;
```

2. 각 물건 `(a, b)`마다 새 배열 `next`를 만들어 상태 전이를 수행합니다.
   - A가 훔치는 경우: `dp[j] + a < n`이면 `next[j]` 갱신
   - B가 훔치는 경우: `j + b < m`이면 `next[j + b]` 갱신

```java
if (dp[j] + a < n) {
    next[j] = Math.min(next[j], dp[j] + a);
}
if (j + b < m) {
    next[j + b] = Math.min(next[j + b], dp[j]);
}
```

3. 각 물건 처리 후 `dp = next`로 교체하면, 해당 시점까지의 모든 선택 결과가 누적됩니다.  
   이렇게 하면 “각 물건은 A 또는 B 중 한 명이 정확히 한 번 훔친다”는 조건이 자연스럽게 반영됩니다.

4. 모든 물건 처리 후 `dp` 배열의 최소값이 정답입니다.  
   끝까지 `INF`만 남으면 두 도둑 모두 기준 미만(`A < n`, `B < m`)을 만족하는 방법이 없으므로 `-1`을 반환합니다.

## :black_nib: **Review**

-

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/389480
