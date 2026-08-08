# [PGS - Lv1] 03_정수 내림차순으로 배치하기

## ⏰**time**
5분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 벡터에 한자리씩 넣어두고 오름차순 정렬한 뒤에 10씩 곱해서 더한다.
   ```cpp
    while(n > 0){
        num.push_back(n%10);
        n /= 10;
    }
    
    sort(num.begin(), num.end());
    
    int size = num.size();
    int ten = 1;
    for(int i = 0; i < size; i++){
        answer += num[i]*ten;
        ten *= 10;
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 lv1 정수 내림차순으로 배치하기](https://school.programmers.co.kr/learn/courses/30/lessons/12933)
