# [PGS - LV2] 12941. 최솟값 만들기

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**
곱의 합을 최소로 하려면 큰 수와 작은 수를 곱해야한다.  
각 배열들을 정렬해서 큰수와 작은수끼리 곱한다.
```java
Arrays.sort(A);
Arrays.sort(B);
for(int i = 0; i<n; i++){
	answer+=A[i] * B[n-i-1];
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12941