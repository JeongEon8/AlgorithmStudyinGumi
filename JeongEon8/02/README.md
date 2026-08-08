# [PGS - Lv1] 02_자연수 뒤집어 배열로 만들기

## ⏰**time**
5분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**
$O(N!)$

## :round_pushpin: **Logic**
1. 10으로 나눈 나머지를 계속 push 한다.
   ```cpp
    while(n > 0){
        answer.push_back(n%10);
        n /= 10;
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv1 자연수 뒤집어 배열로 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12932)
