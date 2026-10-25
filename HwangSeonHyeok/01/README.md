# [PGS - LV2] 131701. 연속 부분 수열 합의 개수


## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 구현
- 브루트포스

## ⏲️**Time Complexity**

$O(n^2)$

## :round_pushpin: **Logic**
최대 길이가 1000이므로 모든 경우의 수로 합을 구해서 set에 넣는다.
```
for(int i = 0; i<elements.length; i++){
	int sum = 0;
	for(int j = 0; j<elements.length; j++){
		sum+= elements[(i+j)%elements.length];
		set.add(sum);
	}
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/131701