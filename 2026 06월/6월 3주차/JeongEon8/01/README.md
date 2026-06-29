# [PGS - Lv2] 01_더 맵게

## ⏰**time**
30분

## :pushpin: **Algorithm**
힙

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 우선순위 큐(역순)를 이용해 맨 앞이 K 이상인지 확인
2. 만약 K보다 작다면 새로운 음식을 만든다. (가장 작은 음식 + 그 다음 작은 음식 * 2)
3. 다 계산 후 pq의 사이즈가 1보다 작거나 같고, top이 K보다 작으면 -1 반환
   ```cpp
    while(pq.size() > 1){
        int first = pq.top();
        if(first >= K){            
            break;
        }
        pq.pop();
        int second = pq.top();
        pq.pop();
        
        int newFood = first + (second * 2);
        pq.push(newFood);
        answer++;
    }
   ```

## :black_nib: **Review**
- 매운걸 상당히 좋아하는 친구구나

## 📡 Link
[프로그래머스 Lv2 더맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626)
