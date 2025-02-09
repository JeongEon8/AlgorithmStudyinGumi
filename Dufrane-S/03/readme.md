# [백준 - S3] 19673. IF문 좀 대신 써줘

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 이분탐색

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
이분탐색하면서 칭호를 탐색. 가장 먼저 나온 칭호를 출력해야하므로 하향 이분탐색

```java
while (start < end) {
                now = (start + end) / 2;
                if (value <= values.get(now)) {
                    end = now;
                    answer = now;
                } else {
                    start = now+1;
                }
            }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/19673
