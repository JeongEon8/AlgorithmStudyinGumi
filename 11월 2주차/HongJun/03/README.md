# [프로그래머스 - Lv2] 땅따먹기

## ⏰  **time**
40분

## :pushpin: **Algorithm**
- DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- DP 테이블을 2차원 배열로 초기화한다
- 첫 번째 줄은 다 밟을 수 있기 때문에 그대로 값을 넣는다
- 이전 행에서 같은 열에 있는 위치는 갈 수 없음
- 같은 열을 제외하고 나머지 열의 숫자들 중 가장 큰 값으로 갱신한다

```
    for (int i = 1; i < n; i++) {
        // j = 현재 열 인덱스
        for (int j = 0; j < 4; j++) {
            // k = 이전 줄에서 같은 열이 아닌 것
            for (int k = 0; k < 4; k++) {
                // 같은 열이면 스킵
                if (j == k) continue;
                // 최대값으로 갱신
                dp[i][j] = Math.max(land[i][j] + dp[i-1][k], dp[i][j]);
            }
        }
    }
```

## :black_nib: **Review**


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/12913
