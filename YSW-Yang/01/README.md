# [PGS - Lv2] 01\_다음 큰 숫자

## ⏰**time**

40

## :pushpin: **Algorithm**

-구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. n을 1씩 증가 시키면서 제일 먼저 나오는 n과 비트수가 같은 수를 반환하게 했다.

   ```java
     while (true) {
         n++;
         if (Integer.bitCount(n) == count) {
             return n;
         }
     }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12911
