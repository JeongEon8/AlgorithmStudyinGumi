# [PGS - Lv2] 01_N개의 최소공배수

## ⏰**time**

30분

## :pushpin: **Algorithm**

수학

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 최소공배수를 두수를 곱하고 최대공약수를 나누어주었다.
   ```
   static int lcm(int a, int b){
           int tmp = 0;
           int na = a;
           int nb = b;
           if(na<nb){
               tmp = nb;
               nb= na;
               na = nb;
           }
           return (a*b)/gcd(a, b);
       }
   ```
2. 최대 공약수는 유클리드 호제법 사용
유클리드 호제법: 두 수를 나머지가 0이 나올때까지 나눈는것을 반복하는거
ex) 8, 6 -> 8 % 6 = 2 => 6 % 2 =0 
2가 최대 공약수가 됨
   ```
   static int gcd(int a, int b){
           
           int na = a;
           int nb = b;
           while(na % nb !=0){
               int tmp = nb;
               
               tmp = na % nb;
               na = nb; 
               nb = tmp;
           }
           
           return nb;
           
       }
   ```

## :black_nib: **Review**

- 유클리드 호제법은 처음 봤어요

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12953
