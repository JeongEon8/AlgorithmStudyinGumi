# [PGS - Lv2] 42578_의상

## ⏰**time**
10분

## :pushpin: **Algorithm**
조합

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 의상 종류 별로 몇 개의 의상이 있는지 count
2. 모든 경우의 수 - 아무 것도 입지 않을 경우
   따라서 (각 옷의 개수 + 1)을 모두 곱한 후에 - 1하면 된다.
   ```cpp
    for(auto i : m){
        answer *= (i.second + 1);
    }
   ```

## :black_nib: **Review**

- 요즘은 TWS에 빠졌어요. 나보다 어린 친구들 좋아해도 되는 건지 참 이상한 감정이 느껴져요..

## 📡 Link
[프로그래머스  Lv2 의상](https://school.programmers.co.kr/learn/courses/30/lessons/42578)
