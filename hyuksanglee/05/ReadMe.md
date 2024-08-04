# [백준 - S3] 11659.구간 합 구하기 4
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
누적합

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 입력받은 수 누적합하여 배열에 담기

2. 입력받은 범위가 start ~ end이면 누적합 배열에서 end까지에 누접합에서 start-1 의 누적합을 빼준다.
  
```java
		for (int n = 1; n<=N; n++) { // 누적합으로 배열 넣기
			arr[n] = Integer.parseInt(input[n-1])+arr[n-1];
		}
		
		for(int n = 0; n<M; n++) { 
			input = br.readLine().split(" "); // i와 j입력 받기
			int i = Integer.parseInt(input[0]); 
			int j = Integer.parseInt(input[1]);
			
			System.out.println(arr[j]-arr[i-1]); // j 에서 i -1 을 빼주면 i~j의 합이 된다.
		}
```

## :black_nib: **Review**
- 처음에 이중 for문을 돌려서 i에서 j 만큼 더했는데 시간초과 하였다.
- 알고리즘 힌트를 얻고 누적합으로 풀었더니 문제를 해결했다.

  
## 📡**Link**

- https://www.acmicpc.net/problem/11659


  
