# [PGS - Lv2] 02_주식가격

## ⏰**time**
5분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 한 가격을 기준으로 다음, 그다음 가격과 비교하며 떨어질 때 break
2. break하기 전까지의 count를 answer에 입력
   ```cpp
    for(int i = 0; i < size - 1; i++){
        int n = prices[i];
        int cnt = 1;
        for(int j = i + 1; j < size - 1; j++){
            if(prices[j] < n){
                break;
            }
            cnt++;
        }
        answer.push_back(cnt);
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv2 주식가격](https://school.programmers.co.kr/learn/courses/30/lessons/42584)
