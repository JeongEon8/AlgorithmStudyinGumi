# [PGS - Lv1] 03_수박수박수박수박수박수

## ⏰**time**
5분

## :pushpin: **Algorithm**
string

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 2로 나눈 나머지가 1이면 박을, 0이면 수를 string에 넣는다.
   ```cpp
    for(int i = 0; i < n; i++){
        if(i%2 == 0){
            answer += watermelon[0];
        }
        else if(i%2 == 1){
            answer += watermelon[1];
        }
    }
   ```

## :black_nib: **Review**
- 콜록콜록.. 감기 조심하세요

## 📡 Link
[프로그래머스 Lv1 수박수박수박수박수박수](https://school.programmers.co.kr/learn/courses/30/lessons/12922)
