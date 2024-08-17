# [백준 - S2] 2477. 참외밭

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

1. 전체길이와 가로,세로 길이를 받는 배열 생성

2. 가로와 세로 각각 최대길이와 인덱스를 뽑는다.

3. 가로와 세로길이를 기준으로 양옆길이를 제외한 나머지 두개를 최대 사각형 넓이에서 빼준다.

4. 넓이를 구한 값에서 참외개수를 곱해준다.

```java
    // 작은 사각형 구하는 식
		for(int i=0; i<6; i++) {
			if(i == indexMC || i == indexMR 
					|| i == (indexMC-1+6)%6 
					|| i == (indexMC+1+6)%6 
					|| i == (indexMR-1+6)%6 
					|| i == (indexMR+1+6)%6 ) {
				continue;
			}
			
			mi *= total[i];
		}
```

## :black_nib: **Review**

- 처음에는 이중 for문을 돌면서 사각형을 1롤 채우려고 했지만 잘되지 않았습니다.

## 📡**Link**

- https://www.acmicpc.net/problem/2477
