# [PGS - Lv1] 02_음양 더하기

## ⏰**time**
5분

## :pushpin: **Algorithm**
연산

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. true면 더하고, false면 뺀다.
   ```cpp
    for(int i = 0; i < size; i++){
        if(signs[i]){
            answer += absolutes[i];
        }
        else{
            answer -= absolutes[i];
        }
    }
   ```

## :black_nib: **Review**
- 예카 가고싶어요ㅠ

## 📡 Link
[프로그래머스 lv1 음양 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/76501)
