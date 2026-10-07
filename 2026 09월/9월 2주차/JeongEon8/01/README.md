# [PGS - Lv1] 01_나누어 떨어지는 숫자 배열

## ⏰**time**
3분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 나눈 나머지가 0이면 answer 벡터에 넣기
   ```cpp
   for(int i = 0; i < size; i++){
       if(arr[i]%divisor == 0){
           answer.push_back(arr[i]);
       }
   }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 lv1 나누어 떨어지는 숫자 배열](https://school.programmers.co.kr/learn/courses/30/lessons/12910)
