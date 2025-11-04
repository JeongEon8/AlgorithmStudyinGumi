# [백준 - 실버 3] 14501. 퇴사

## ⏰  **time**
15분

## :pushpin: **Algorithm**
DP(동적 계획법)

## ⏲️**Time Complexity**
$O(N)$

* 각 날짜를 한 번씩만 순회하며 점화식 갱신

## :round_pushpin: **Logic**
* 퇴사일까지 남은 `N`일 동안, 상담 일정 `Ti`와 보상 `Pi`가 주어짐
* 각 날짜에 상담을 **할지 말지 결정**해야 하며, 겹치면 안 됨
* 퇴사 전에 끝나는 상담만 가능 (`i + Ti <= N`)
* 얻을 수 있는 **최대 수익**을 출력
```cpp
for(int i = 0; i <= N; i++) {
    dp[i] = max(dp[i], max_pay);  // 현재까지 수익 보장
    if (T[i] + i <= N) {
        dp[i + T[i]] = max(dp[i + T[i]], dp[i] + P[i]);
    }
    max_pay = max(max_pay, dp[i]);  // 전체 최대값 갱신
}
```

## ✅ Review
* 아주 전형적인 **누적 최대값 DP** 문제!
* `dp[i + T[i]]`를 갱신할 때, **지금까지의 최선 경로에서 상담을 선택한 것**이므로 신중해야 함
* `dp`에 누적되는 의미를 명확히 이해하면 쉽게 풀리는 문제

## 📡 Link
[https://www.acmicpc.net/problem/14501](https://www.acmicpc.net/problem/14501)
