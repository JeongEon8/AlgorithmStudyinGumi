
# [프로그래머스 - Lv.2] 땅따먹기

## ⏰  **time**
20분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- DP 테이블을 2차원 배열로 만들어서 첫 번쨰 줄은 그대로 값을 넣는다
- 이전 행에서 같은 열에 있는 위치로는 갈 수 없다
- 같은 열을 제외하고 나머지 열의 숫자들 중 가장 큰 값으로 갱신한다.

```kotlin
    // DP 채우기
    for (i in 1 until n) {
        for (j in 0 until 4) {
            for (k in 0 until 4) {
                if (j == k) continue
                dp[i][j] = maxOf(dp[i][j], land[i][j] + dp[i - 1][k])
            }
        }
    }
```

## :black_nib: **Review**


## 📡**Link**

- https://school.programmers.co.kr/learn/courses/30/lessons/12913