# [PGS - Lv1] 02_문자열 내 p와 y의 개수

## ⏰**time**
10분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 대문자 소문자를 나눠 P와 y를 확인함
   ```cpp
   for(int i = 0; i < s.size(); ++i) {
       if(s[i] == 'p' || s[i] == 'P') p++;
       else if(s[i] == 'y' || s[i] == 'Y') y++;
   }
   if(p == 0 && y == 0) return true;
   else if(p == y) return true;
   else return false;
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv1 문자열 내 p와 y개수](https://school.programmers.co.kr/learn/courses/30/lessons/12916)
