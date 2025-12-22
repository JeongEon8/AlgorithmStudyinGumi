# [백준 -G4] 1715 - 카드 정렬하기

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그리디
- 우선순위큐

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
그리디하게 작은 수끼리 더하면 가장 작은 비교 수를 구할 수 있다.
하지만 작은 수끼리 더한 값이 그 다음 더 할 작은 수가 아닐 수 있다.
우선순위큐를 통해 정렬 상태를 유지해준다.


```java
 while (pq.size() != 1) {
            int n = pq.poll();
            int m = pq.poll();
            answer += (m + n);
            pq.add(n + m);
        }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/submit/1715
