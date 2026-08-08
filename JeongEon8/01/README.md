# [PGS - Lv1] 01_자릿수 더하기

## ⏰**time**
10분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**
$O(N!)$

## :round_pushpin: **Logic**
1. 10으로나눈 나머지를 계속 더한다.
   ```cpp
    while(n > 0){
        answer += n % 10;
        n /= 10;
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 lv1 자릿수 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/12931)
