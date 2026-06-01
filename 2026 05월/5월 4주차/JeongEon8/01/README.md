# [PGS - Lv2] 131127_할인 행사

## ⏰**time**
20분

## :pushpin: **Algorithm**
map

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 맵에 {물품이름, 개수}로 10개 미리 넣는다.
2. 사려고 했던 물품의 개수가 맞는지 확인한다.
   ```cpp
    for(int i = 0; i < discount.size() - 9; i++){
        bool signUp = true;
        
        for(int j = 0; j < want.size(); j++){
            if(m[want[j]] != number[j]){
                signUp = false;
                break;
            }
        }
        
        if(signUp){
            answer++;
        }
        
        m[discount[i]]--;
        if(i < discount.size() - 10){
            m[discount[i+10]]++;
        }
    }
   ```

## :black_nib: **Review**
- 요즘은 TWS에 빠졌어요. 나보다 어린 친구들 좋아해도 되는 건지 참 이상한 감정이 느껴져요..

## 📡 Link
[프로그래머스 Lv2 할인행사](https://school.programmers.co.kr/learn/courses/30/lessons/131127)
