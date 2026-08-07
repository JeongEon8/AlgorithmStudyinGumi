# [PGS - Lv2] 02_연속 부분 수열 합의 개수

## ⏰**time**
30분

## :pushpin: **Algorithm**
부분 수열의 합

## ⏲️**Time Complexity**
$O(N!)$

## :round_pushpin: **Logic**
1. set을 사용하여 부분 수열의 합들 저장
2. 원형 수열의 부분 수열을 구하는 부분은 이중 반복문
   ```cpp
    for(int i = 0; i < elements.size(); ++i)
    {
        int sum = 0;
        for(int j = i; j < i+elements.size(); ++j)
        {
            int idx = j % elements.size();
            sum += elements[idx];
            sums.emplace(sum);
        }
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv2 연속 부분 수열 합의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/131701)
