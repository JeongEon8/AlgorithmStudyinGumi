# [PGS - LV2] 12985. 예상 대진표

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(logn)$

## :round_pushpin: **Logic**
매 라운드마다 N/2 경기로 배치를 받으니 같은 경기에 배치되는 라운드를 찾으면 된다.
```java
int answer = 0;
while(a!=b){
	a = (a+1)/2;
	b = (b+1)/2;
	answer++;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12985