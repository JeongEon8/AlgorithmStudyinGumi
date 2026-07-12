# [PGS - LV2] 12945. 피보나치 수

## ⏰ **time**

5분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
반복문을 이용한 피보나치 풀이.
```java
int current = 1;
int p = 0;
int pp = 0;
for(int i = 1; i<n; i++){
	pp = p;
	p = current;
	current = (p + pp)%1234567;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12945