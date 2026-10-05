# [PGS - LV2] 12949. 행렬의 곱셈


## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(n^3)$

## :round_pushpin: **Logic**
행렬의 곱색하는 방법을 구현하면 된다.
```
for(int i = 0; i<r; i++){
	for(int j = 0; j<c; j++){
		for(int k = 0; k<arr1[0].length; k++){
			answer[i][j] += arr1[i][k] * arr2[k][j];
		}
	}
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12949?language=java