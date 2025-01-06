# [백준 - G5] 1911. 흙길 보수하기

## ⏰ **time**

70분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

구덩이를 정렬한 후 구덩이를 덮을 수 있는 판자 수를 구한 뒤 마지막 판자가 다른 구덩이를 덮는지 판단

```java
	        for (Hole hole : list) {
            if (before > hole.end) continue;
            int length;
            if (hole.start < before) {
                length = hole.end - before;
            } else {
                length = hole.end - hole.start;
                before = hole.start;
            }
            int tmp;
            if (length % L == 0) {
                tmp = length / L;
            } else {
                tmp = length / L + 1;
            }
            before = before + tmp * L;
            answer += tmp;
        }

```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/1911
