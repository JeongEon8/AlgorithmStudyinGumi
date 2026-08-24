# [PGS - Lv1] 02_문자열 다루기 기본

## ⏰**time**
5분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 문자열이 4거나 6이 아니면 false
2. 문자열 하나씩 탐색하면서 숫자가 아니면 false
   ```cpp
    if(s.length() == 4 || s.length() == 6){
        for(int i = 0; i < s.length(); i++){
            if(!isdigit(s[i])){
                answer = false;
                break;
            }
        }
    }
    else{
        answer = false;
    }
   ```

## :black_nib: **Review**
- 문제를 끝까지 읽자.. 

## 📡 Link
[프로그래머스 lv1 문자열 다루기 기본](https://school.programmers.co.kr/learn/courses/30/lessons/12918)
