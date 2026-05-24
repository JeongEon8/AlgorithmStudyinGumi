# [PGS - Lv2] 138476_귤 고르기

## ⏰**time**
25분

## :pushpin: **Algorithm**
맵

## ⏲️**Time Complexity**
$O(NlogN)$ 

## :round_pushpin: **Logic**
1. 내림차순으로 정렬하고 한도까지 귤을 넣는다!
   ```cpp
    for(int i = 0; i < v.size(); i++){
        if(cnt >= k) {
            break;
        }
        
        answer++;
        cnt += v[i];
    }
   ```

## :black_nib: **Review**
- 오늘은 부처님 오신 날~

## 📡 Link
[프로그래머스 lv2 귤 고르기](https://school.programmers.co.kr/learn/courses/30/lessons/138476)
