# [백준 - S2] 10971. 외판원 순회 2
 
## ⏰  **time**
50븐

## :pushpin: **Algorithm**
- dfs

## :round_pushpin: **Logic**
- 도시의 개수 N과 N x N 비용 배열 생성

- 방문 배열 isSelected를 생성하고, 최소 비용을 저장할 min를 최댓값으로 초기화
- 0번 도시에서 출발하므로, 0번 도시는 방문 처리합니다.

- dfs 탐색
  	- 출발 도시(0번)에서 시작해 모든 도시
  	- 모든 도시를 방문한 후 출발점으로 돌아오는 비용을 포함해 최소 비용을 계산

- 계산된 최소 비용을 출력

```java
// dfs
	public static void dfs(int n, int sum, int num) { // n: 현제 위치, sum : 지금까지 비용, num:dfs 들어온 횟수
		
		if(num==N && arr[n][0] != 0) { //
			if(min> sum+ arr[n][0]) {
				sum+= arr[n][0];
				min=sum;
			}
			return;
		}
		
		
		for(int i =0; i<N; i++) {
			if(isSelected[i]== false && arr[n][i]!=0) {
				isSelected[i]=true;
				dfs(i, sum+ arr[n][i], num+1);
				isSelected[i]=false;
				
			}
		}
	}
```

## :black_nib: **Review**
- 처음에 모든 지역을 방문 못했을 경우 처리를 못해서 틀렸습니다.

## 📡**Link**
- https://www.acmicpc.net/problem/10971
