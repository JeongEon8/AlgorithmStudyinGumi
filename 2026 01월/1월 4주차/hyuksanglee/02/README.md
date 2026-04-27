# [백준 - G5] 14719. 빗물

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
1. 왼쪽부터 차례대로 돌면서 왼쪽에 가장 큰값이랑 오른쪽에 가장 큰값을 찾아서 그중에 작은 값을 빼주면 된다.

```java
for (int i = 1; i < W - 1; i++) {
            int l = 0;
            int r = 0;
            for (int j = 0; j <= i; j++) {
                l = Math.max(l, arr[j]);
            }
            for (int j = i; j < W; j++) {
                r = Math.max(r, arr[j]);
            }
            int min = Math.min(l, r);
            total += (min - arr[i]);
        }
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/14719](https://www.acmicpc.net/problem/14719)
