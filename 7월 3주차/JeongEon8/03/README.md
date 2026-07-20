# [PGS - Lv2] 02_n^2 배열 자르기

## ⏰**time**
30분

## :pushpin: **Algorithm**
탐색

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 현재 인덱스를 n으로 나눈 몫은 x, 나머지는 y 좌표가 되므로 각각을 long long형 변수 x, y에 저장
2. y가 크면 y에 1을 더한 값을, 이외의 경우에는 else문을 사용하여 x에 1을 더한 값을 저장
   ```cpp
    for(long long i = left; i <= right; ++i) {
        long long x = i / n;
        long long y = i % n;
        if(x < y) answer.push_back(y + 1);
        else answer.push_back(x + 1);
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 lv2] n^2 배열 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/87390)
