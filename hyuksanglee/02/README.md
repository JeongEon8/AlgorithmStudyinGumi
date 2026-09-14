# [PGS - Lv2] 02_멀리 뛰기

## ⏰**time**

24분

## :pushpin: **Algorithm**

DP

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. dp를 이용해서 1부터 N까지 차례대로 계산
   ```
   long[] dp = new long[n+1];
           
           
           for(int i =1; i<= n; i++){
               if(i==1)dp[1] =1;
               else if(i ==2)dp[2] =2;
               else dp[i] = (dp[i-1]+dp[i-2])% 1234567;
           }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12914
