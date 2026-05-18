# [PGS - Lv2] 42885_구명보트

## ⏰**time**
1시간

## :pushpin: **Algorithm**
투포인터

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 오름차순 정렬
2. 투포인터를 통해 하나씩 당기며 두개 합이 한계보다 작으면 앞을 당기고, 그외를 뒤를 당긴다.
   ```cpp
    while (ptr <= ptr2) {
        if (people[ptr] + people[ptr 2] <= limit){
            ptr++;
        }
     
        ptr2--;
        answer++;
    }
   ```

## :black_nib: **Review**
- 대 상 혁

## 📡 Link
[프로그래머스 Lv2 구명보트](https://school.programmers.co.kr/learn/courses/30/lessons/42885)
