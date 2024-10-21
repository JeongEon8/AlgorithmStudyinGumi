# [백준] 21921. 블로그 
 
## ⏰  **time**
40분 

## :pushpin: **Algorithm**
누적 합 

## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
- 처음 x일간의 합을 먼저 구해 둔다.
```java
		for (int i = 0; i < x; i++) {
			result += arr[i];
		}
```

- start에 이 합을 저장해둔다.
- 앞의 한 값을 빼고, 뒤의 한 값을 빼는 식으로 새 합을 구한다.
```java
		for (int i = 1; i <= n-x; i++) {
			start = start-arr[i-1] + arr[i+x-1];
			
			if(start>result) { //새 최댓값이 나타나면 
				result = start; //갱신하고 
				count = 1; //count 1으로 초기화 
			} else if (start == result ) { //동일한 최댓값 등장시 
				count++; //count 추가 
			}
		}
```

- 조건에 맞게 출력한다... 


## :black_nib: **Review**
- 처음에는 한 반복문 내에서 모든 합을 처리하려고 했었다. x일간의 합을 구하고... 다시 구하고...^^
- 그런데 앞의 값을 빼고 뒤의 값을 더한다니 간단하잖아~ 

## 📡**Link**
- https://www.acmicpc.net/problem/21921 
