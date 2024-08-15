# [백준 - S5] 2669. 네개의 합집합의 면적 구하기

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

1. 가로 좌표와 세로 좌표를 받는 배열 생성

2. 자르기 전에 가로와 세로를 (0,0)을 포함해서 배열에 넣어준다.

3. 입력 받은 자르는 부분을 가로로 자르면 세로 배열에 추가 해주고 세로로 자르면 가로 배열에 추가 해준다.

4. 가로 배열과 세로 배열을 정렬을 하기 위해 리스트에 옴겨준다.

5. 정렬을 하고 리스트에서 2개씩 뽑아서 면적을 구하고 최댓값 비교후 갱신해준다.

```java
    for(int i = 0; i<listW.length-1; i++) {
	for(int j=0; j<listH.length-1; j++) {
		int total = Math.abs(listW[i]-listW[i+1]) * Math.abs(listH[j]-listH[j+1]);
			if(max < total) {
				max = total;
			}
		}
	}
```

## :black_nib: **Review**

- 이번 문제는 쉬웠어요

## 📡**Link**

- https://www.acmicpc.net/problem/2628
