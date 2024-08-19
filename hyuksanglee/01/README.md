# [백준 - S5] 2669. 네개의 합집합의 면적 구하기

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

1. 101 x 101배열을 만들어준다.

2. 직사각형에 면적에 해당하는 구역을 1로 표시한다.

3. 마지막으로 1의 개수를 세어서 출력한다.

```java
    // 입력 받기
		for (int n = 0; n < 4; n++) {
			String[] input = in.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]); 
			int y1 = Integer.parseInt(input[1]);
			int x2 = Integer.parseInt(input[2]);
			int y2 = Integer.parseInt(input[3]);
		
			for(int i = x1;i<x2;i++) { 		// x1에서 x2까지
				for(int j =y1; j<y2; j++) {	// y1에서 y2까지
					arr[i][j] =1;			// 직사각형 면적을 1로 표시해준다.
				}
			}

		}
```

## :black_nib: **Review**

- 처음에는 해당 사각형을 구해서 곁치는 부분을 지우려고 했지만 3개가 곁치는 부분에 예외처리를 하지못해서 구현을 못했습니다.

## 📡**Link**

- https://www.acmicpc.net/problem/2669
