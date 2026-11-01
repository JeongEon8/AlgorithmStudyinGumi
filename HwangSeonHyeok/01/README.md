# [PGS - LV2] 87390. n^2 배열 자르기


## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
2차원 배열의 각 칸은 행, 열의 인덱스중 더 큰 값이다.  
left~right까지를 행, 열을 구해서 값을 유추해넣는다.
```
for(long i = left; i<=right; i++){
	long r = i/n;
	long c = i%n;
	
	answer[idx++] = (int)Math.max(r,c)+1;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/87390