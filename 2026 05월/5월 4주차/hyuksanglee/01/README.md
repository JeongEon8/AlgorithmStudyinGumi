# [PGS - Lv2] 01_H-Index

## ⏰**time**

28분

## :pushpin: **Algorithm**
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 일단 정렬 시켜준다.
   ``` java
    Arrays.sort(citations);
   ```
2. 뒤에서부터 인용 횟수를 늘려주면서 비교해서 작은 값이 나올때 까지 반복한다.
   ``` java
    for(int i = end; i>=0; i--){
            
           int num = citations[i];
            if(num<index){
                return index-1;
            }
                index++;
        }
   ```
## :black_nib: **Review**

- 문제 이해가 잘 안되는 문제였음

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42747
