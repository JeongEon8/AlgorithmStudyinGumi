# [백준 - S5] 25584. 근무 지옥에 빠진 푸앙이 (Large)

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 자료 구조
- 문자열
- 집합과 맵
- 해시를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
map으로 각 근무자들의 근무시간을 계산하고 가장 많이 근무한 사람의 시간과 적게 근무한 사람의 시간을 찾아 공평한지 판별한다.

```java
Map<String, Integer> map = new HashMap<>();
int[] time = { 4, 6, 4, 10 };
for (int i = 0; i < n; i++) {
    for (int j = 0; j < 4; j++) {
        String[] workers = in.readLine().split(" ");
        for (String worker : workers) {
            if (worker.equals("-"))
                continue;
            map.put(worker, map.getOrDefault(worker, 0) + time[j]);
        }
    }
}
int min = Integer.MAX_VALUE;
int max = 0;
for (int t : map.values()) {
    min = Math.min(min, t);
    max = Math.max(max, t);
}
```
## :black_nib: **Review**

## 📡**Link**
https://www.acmicpc.net/problem/25584