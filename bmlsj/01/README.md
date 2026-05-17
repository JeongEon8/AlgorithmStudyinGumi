# [PGS - Lv3] 01\_순위

## ⏰**time**

60분

## :pushpin: **Algorithm**

플로이드 워셜

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- A > B, B > C이면 A > C 임을 판단하는 문제
- `win[a][b]` : a가 b를 이김

1. 반복문을 돌면서 `i -> k -> j`가 유효한 관계의 수를 센다.
2. 자기 자신을 제외한 모든 선수와 비교 가능하면, 순위가 정해진 것이므로 `answer++`

```java
// a > b, b > c 이면, a > c
for(int k = 1; k <= n; k++) {
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            if (win[i][k] && win[k][j]) {
                win[i][j] = true;
            }
        }
    }
}

for(int i = 1; i <= n; i++) {
    int cnt = 0;

    for(int j = 1; j <= n; j++) {
        if (win[i][j] || win[j][i]) {
            cnt++;
        }
    }

    if (cnt == n - 1) {
        answer++;
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/49191?language=java>
