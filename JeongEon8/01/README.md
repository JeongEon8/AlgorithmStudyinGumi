# [PGS - Lv1] 01_내적

## ⏰**time**
5분

## :pushpin: **Algorithm**
산수

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. a, b의 첫번째부터 마지막 원소까지 순환하고, 같은 인덱스의 a, b의 원소를 곱한값을 answer에 더하여 저장.loop 탈출 후, 최종적으로 저장된 answer을 return

   ```cpp
   for(int i = 0; i < a.size(); ++i) {
       answer += a[i] * b[i];
   }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 lv1 내적](https://school.programmers.co.kr/learn/courses/30/lessons/70128?language=cpp)
