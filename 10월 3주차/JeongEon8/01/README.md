# [PGS - Lv1] 01_정수 제곱근 판별

## ⏰**time**


## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 제곱근인가~? 아닌가~?
   ```cpp
   long long answer = 0;
   long long a = sqrt(n);
   if (a*a == n) {	// 양의 정수x의 제곱인 경우
       answer=pow(a+1,2);
   }
   else {	// 아닌 경우
       answer=-1;
   }
   return answer;
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv1 정수 제곱근](https://school.programmers.co.kr/learn/courses/30/lessons/12934)
