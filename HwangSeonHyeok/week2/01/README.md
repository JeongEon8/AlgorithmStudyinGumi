# [백준 - S1] 16568. 엔비스카의 영혼

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**

기본적으로 매초 줄이 1명씩 줄어드는것은 실질적으로 1칸 전진 하는 것과 같다.  
이를 이용해서 기다리기(+1), a명 앞으로 가기(+a+1), b명 앞으로 가기(+b+1) 3가지 경우를 가진 dp 문제로 풀이 하였다.

```cpp
    for (int i = 1; i <= n; i++) {
        // 줄에서 1명 줄음 = 1칸 전진
        int currentTime = dp[i - 1] + 1;

        // a칸세치기+1명 줄음 = a+1칸 전진
        // 현제까지 최소 시간 걸린것을 현제 소요시간으로 저장
        if (i >= a + 1) {
            currentTime = dp[i - 1 - a] + 1 < currentTime ? dp[i - 1 - a] + 1 : currentTime;
        }

        // b칸세치기+1명 줄음 = b+1칸 전진
        // 현제까지 최소 시간 걸린것을 현제 소요시간으로 저장
        if (i >= b + 1) {
            currentTime = dp[i - 1 - b] + 1 < currentTime ? dp[i - 1 - b] + 1 : currentTime;

        }
        dp[i] = currentTime;
    }
```

## :black_nib: **Review**

## 📡**Link**

- https://www.acmicpc.net/problem/16568
