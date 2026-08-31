# [PGS - Lv1] 01_가운데 글자 가져오기

## ⏰**time**
10분

## :pushpin: **Algorithm**
string

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 홀수면 하나, 짝수면 가운데 두개
   ```cpp
   if(s.size() % 2 == 1) {
       answer += s[s.size() / 2];
   }
   else {
       answer += s[s.size() / 2 - 1];
       answer += s[s.size() / 2];
   }
   
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 lv1 가운데 글자 가져오기](https://school.programmers.co.kr/learn/courses/30/lessons/12903?language=cpp)
