# [백준 - 실버 5] 1427. 소트인사이드
 
## ⏰  **time**
10분분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 입력 받은 수를 오름차순으로 정렬한다.
2. 뒤에서부터 값을 출력한다.
```java
Arrays.sort(num);
    
    for(int i = num.length-1; i >= 0; i--) {
        System.out.print(num[i]);
}
```

## :black_nib: **Review**
- 완전탐색 사랑해요

## 📡 Link
https://www.acmicpc.net/problem/1427
