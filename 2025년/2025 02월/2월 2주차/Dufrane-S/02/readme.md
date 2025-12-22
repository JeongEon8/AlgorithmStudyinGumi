# [백준 - S5] 9881. Ski Course Design

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 브루트포스

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1~18부터 83~100까지 모든 경우의 수의 비용을 계산해서 최소 값을 찾기

```java
 for (int i = 1; i < 101 - 17; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (counts[j] != 0) tmp += (i - j) * (i - j) * counts[j];
            }
            for (int k = 100; k > i + 17; k--) {
                if (counts[k] != 0) tmp += (k - (i + 17)) * (k - (i + 17)) * counts[k];
            }
            if (answer > tmp) answer = tmp;
        }
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/9881
