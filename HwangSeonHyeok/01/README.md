# [PGS - LV2] 152996. 시소 짝꿍


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
각 무개의 갯수를 카운팅하고 평형을 유지할 수 있는 무개와 곱해서 더한다.
```java
for(int weight: weights){
	count[weight]++;
}
for(int i = 1; i<=1000; i++){
	long currentCnt = count[i];
	if(currentCnt==0) continue;
	answer+= currentCnt * (currentCnt-1) / 2;
	
	if(i * 3 % 2 == 0 && i * 3 / 2 <= 1000) {
		answer += currentCnt * count[i * 3 / 2];
	}
	
	if(i * 2 <= 1000) {
		answer += currentCnt * count[i * 2];
	}
	
	if(i * 4 % 3 == 0 && i * 4 / 3 <= 1000) {
		answer += currentCnt * count[i * 4 / 3];
	}
	
	
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/152996