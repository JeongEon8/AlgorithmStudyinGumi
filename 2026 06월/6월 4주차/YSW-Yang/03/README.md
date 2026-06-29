# [PGS - Lv2] 03_점 찍기

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 수학
- 구현

## ⏲️**Time Complexity**

$O(d/k)$

## :round_pushpin: **Logic**

1. x 좌표를 k 단위로 고정하고, 각 x에 대해 원의 조건 x^2 + y^2 <= d^2를 이용해 y의 최대값을 구한다.
즉 y^2 ≤ d^2 - x^2가 되므로, 가능한 y는 0부터 maxY까지 k 간격으로 존재한다.
따라서 개수는 maxY / k + 1이 되고, 이를 모든 x에 대해 누적하여 답을 구한다.
   ```java
        for(long x = 0; x <= d; x += k){
            long maxY = (long) Math.sqrt(d2 - x * x);
            answer += maxY / k + 1;
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/140107
