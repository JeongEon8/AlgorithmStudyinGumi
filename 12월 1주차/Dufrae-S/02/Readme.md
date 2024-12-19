# [백준 - G4] 11404. 플로이드

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 플로이드 와샬

## ⏲️**Time Complexity**

$O(N)^3$

## :round_pushpin: **Logic**

플로이드 와샬 기본 구현

```java
for (int j = 0; j < edge; j++) {
            for (int i = 0; i < edge; i++) {
                if (i == j || list[i][j] == Integer.MAX_VALUE) continue;
                for (int k = 0; k < edge; k++) {
                    if (i == k || j == k || list[j][k] == Integer.MAX_VALUE)
                        continue;
                    if (list[i][j] + list[j][k] < list[i][k]) {
                        list[i][k] = list[i][j] + list[j][k];
                    }
                }
            }
        }
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/11404
