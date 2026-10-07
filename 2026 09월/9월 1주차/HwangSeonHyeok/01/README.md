# [PGS - LV2] 12911. 다음 큰 숫자

## ⏰ **time**

	10분

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
while문으로 비트카운트가 같은 다음 숫자를 찾을 때까지 반복한다.
```java
int nBit = Integer.bitCount(n);
int current = n+1;
while(true){
	if(nBit==Integer.bitCount(current)){
		return current;
	}
	current++;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12911