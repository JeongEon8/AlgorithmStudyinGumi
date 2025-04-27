# [백준 - 실버 3] 9375.패션왕 신해빈

## ⏰  **time**
15분

## :pushpin: **Algorithm**
조합론

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 하나라도 걸치면 되니까 종류별 의상 수 + 1 씩 곱하기, 알몸은 안되니까 1 빼기
```java
              while (keys.hasNext()){
                String key = keys.next();
                result *= (clothes.get(key).size() +1);
            }
```

## :black_nib: **Review**
- 프로그래머스 lv.2 의상이랑 완전 비슷한 문제다 개꿀!

## 📡 Link
https://www.acmicpc.net/problem/9375
