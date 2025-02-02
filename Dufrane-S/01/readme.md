# [백준 - G5] 1074. Z

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 분할정복

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
영역을 사분면으로 나누어 계산한다

```java
for (int i = 0; i < N; i++) {
            if (k / 2 > n && k / 2 > m) {//2사분면
                answer += 0;
            } else if (k / 2 <= n && k / 2 > m) {//3사분면
                answer += (k / 2) * (k / 2) * 2;
                n -= k / 2;
            } else if (k / 2 > n && k / 2 <= m) {//1사분면
                answer += (k / 2) * (k / 2);
                m -= k / 2;
            } else if (k / 2 <= n && k / 2 <= m) {//4사분면
                answer += (k / 2) * (k / 2) * 3;
                n -= k / 2;
                m -= k / 2;
            }
            k /= 2;
        }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/1074
