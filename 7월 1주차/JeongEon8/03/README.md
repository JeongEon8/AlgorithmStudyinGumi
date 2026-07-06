# [PGS - Lv2] 03_2 x n 타일링

## ⏰**time**
5분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. n = (n - 1) + (n - 2)
   ```cpp

    for(int i = 3; i <= n; i++) {
        answer = (prev + tmp) % 1000000007;
        prev = tmp;
        tmp = answer;
    }
   ```

## :black_nib: **Review**
- 이거 백준에 있던건데..

## 📡 Link
[프로그래머스 lv2 2xn 타일링](https://school.programmers.co.kr/learn/courses/30/lessons/12900)
