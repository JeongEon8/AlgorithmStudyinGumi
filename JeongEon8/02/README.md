# [PGS - Lv2] 12914_멀리 뛰기

## ⏰**time**
30분

## :pushpin: **Algorithm**
DP(피보나치 수열)

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. run[i] = run[i-1] + run[i-2]
   ```cpp
    for(int i = 3; i <= n; i++){
        run[i] = (run[i-1] + run[i-2]) %1234567;
    }
   ```

## :black_nib: **Review**
- 오늘은 부처님 오신 날~

## 📡 Link
[프로그래머스 lv2 멀리뛰기](https://school.programmers.co.kr/learn/courses/30/lessons/12914)
