# [PGS - Lv2] 01_H-Index

## ⏰**time**
30분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. h는 현재 논문 인용 개수 중 최대로 설정
2. h번 이상 인용된 것을 count
3. cnt가 h번 이상이고, size - cnt가 h 이하라면 출력
   ```cpp
    for(int h = citations[size - 1]; h >= 0; h--){
        int cnt = 0;
        for(int j = 0; j < size; j++){
            if(citations[j] >= h){
                cnt++;
            }
        }
        if(cnt >= h && size - cnt <= h){
            answer = h;
            break;
        }
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv2 H-index](https://school.programmers.co.kr/learn/courses/30/lessons/42747)
