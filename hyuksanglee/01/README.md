# [백준 - G3] 1922.네트워크 연결 
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
dfs, mst

## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
1. 인터넷을 설치하는 비용을 담는 이차원 배열, 방문여부를 체크를 하는 1차원 배열, 각 지점에 설치하는 최소 비용을 담는 1차원 배열 생성
   
2. 이차원 배열을 사용하여 연결되어 있는 두 지점에 비용 적기
   - 예를 들어) 3번하고 4번을 연결하는데 비용이 10이면 arr[3][4] = 10, arr[4][3] = 10 두 지점에 비용을 입력한다.
     
3. dfs는 0부터 시작하고 0번째 행에서 비용이 0이 아니고 방문 안 한곳의 비용을 배열에 값이랑 비교 하여 갱신 해준다.

4. 비용 배열에서 방문을 안하고 최소 비용인 곳을 dfs 탐색을 해준다.

5. dfs탐색이 모두 종료되면 비용 배열에 저장 되어 있는 값을 모두 더해서 출력 해준다.
	
```java
	public static void dfs(int n, int count) {
		if(count>N) {
			return;
		}
		
		int index =0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			if(!isSelected[i]) {
				
				if(arr[n][i]<cost[i] && arr[n][i]!=0) {
					cost[i]=arr[n][i];
				}
				if(min>cost[i]) {
					min = cost[i];
					index = i;
				}
				
			}
		}
		
		isSelected[index] =true; 
		dfs(index,count+1);
	}
```



## :black_nib: **Review**
- 너무 오랜만에 알고리즘 문제를 풀다보니 실수를 많이 했어요

## 📡**Link**
- https://www.acmicpc.net/problem/1922
