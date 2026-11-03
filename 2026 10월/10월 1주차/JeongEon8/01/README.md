# [PGS - Lv1] 01_하샤드 수

## ⏰**time**
10분

## :pushpin: **Algorithm**
산수

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 최대값으로 divid를 설정하고, 이를 10씩 나눠가며 x의 자릿수를 찾는다.
2. 자리수끼리 더해서 x가 나누어떨어지지 않으면 false한다.
   ```cpp
   int sum = 0;
   int divid = 10000;
   int num = x;
   
   while(x/divid == 0)
   {
       divid /= 10;
   }
   
   while(divid >= 1)
   {
       sum += num / divid;
       num %= divid;
       divid /= 10;
   }
   
   if(x % sum != 0)
   {
       answer = false;
   }
   ```

## :black_nib: **Review**
- 야근 에바.

## 📡 Link
[프로그래머스 lv1 하샤드 수](https://school.programmers.co.kr/learn/courses/30/lessons/12947)
