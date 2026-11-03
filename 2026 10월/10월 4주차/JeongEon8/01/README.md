# [PGS - Lv1] 01_콜라츠 추측

## ⏰**time**
3분


## :pushpin: **Algorithm**
산수

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 짝수면 2로 나누고, 홀수면 3을 곱한 후 1을 더한다.
2. 이때, 1회 계산이 끝나면 answer에 1을 더한다.
3. answer가 500이 넘어가면 answer는 -1로 저장하고 break한다.
4. num의 숫자가 int 범위를 넘어갈 수 있으므로 long long 자료형을 활용한다.
   ```cpp
   long long n = num;
   
   while(n != 1)
   {
       if(n%2==0)
       {
           n /= 2;
       }
       else
       {
           n *= 3;
           n += 1;
       }
       
       ++answer;   
       if(answer >= 500)
       {
           answer = -1;
           break;
       }
   }
   ```

## :black_nib: **Review**
- 감기 조심하세용

## 📡 Link
[프로그래머스 Lv1 콜라츠 추측](https://school.programmers.co.kr/learn/courses/30/lessons/12943)
