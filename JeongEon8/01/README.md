# [PGS - Lv1] 01_약수의 합

## ⏰**time**
10분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 나눠지면 정답에 1을 더해 그 숫자를 만든다.
   ```cpp
   for(int i=1;i<=n;i++)
   {
       if(n%i==0)
           answer+=i;
   }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv1 약수의 합](https://school.programmers.co.kr/learn/courses/30/lessons/12928)
