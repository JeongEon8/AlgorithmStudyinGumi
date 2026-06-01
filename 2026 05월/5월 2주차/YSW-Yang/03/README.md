# [PGS - Lv2] 03_숫자의 표현

## ⏰**time**

30분

## :pushpin: **Algorithm**

- 투 포인터

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

연속된 수의 합으로 n을 만들 수 있는 경우의 수가 몇개인지 확인하는 문제였다.
일정한 구간의 합을 효율적으로 구하기 위해 투 포인터 알고리즘을 사용해서 문제를 풀었다.

   ```
        int left = 1;
        int right = 1;
        
        int sum = 0;
        while(left <= n){
            if(sum > n){
                sum -= left;
                left++;
            }else{
                if(sum == n){
                    answer++;
                }
                sum += right;
                right++;
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12924
