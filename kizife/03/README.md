# [백준] 21278. 호석이 두 마리 치킨 
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
브루트포스, 플로이드-워셜  

## ⏲️**Time Complexity**
O(N^3)

## :round_pushpin: **Logic**
거리를 저장할 배열 만들기...
```java
		for (int i = 0; i <=n; i++) {
			for (int j = 0; j <=n; j++) {
				if (i!=j) arr[i][j] = 100; //거리 100으로 임시 초기화 
			}
		}
```

건물 간 거리를 정리해준다.
```java
		for (int i = 1; i <=n; i++) { //중간에 경유할 수 있는 지점
			for (int j = 1; j <=n; j++) { //출발하는 빌딩 
				for (int k = 1; k <=n; k++) { //도착점 
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]); //바로 가기 vs. 경유하기 
				}
			}
		}
```

두 건물에 치킨집을 각각 두었을 때, 각 빌딩에서 가장 가까운 치킨집까지의 거리 구하기
```java
		for (int i = 1; i <=n; i++) { //치킨집1 
			for (int j = i+1; j <=n; j++) { //치킨집2 
				int sum = 0; //치킨집 조합 바뀔 때마다 초기화해줌 
				
				for (int k = 1; k <=n; k++) { //빌딩k에서 치킨집까지의 거리 합 
					sum += Math.min(arr[k][i], arr[k][j]) *2;
					//왕복이니까 *2 해줌 
					//i, j까지의 거리 중 가까운 것을 선택해서 더함 
				}
				
				if (sum < min) { //치킨집 조합 바뀌었을 때 최소값이 더 작다면, 갱신해줌.
					min = sum;
					building1 = i;
					building2 = j;
				}
			}
		}
```

## :black_nib: **Review**
- 로직 자체는 단순한 문제이지만, 각 변수의 초기화나 갱신을 신경써야 하는 문제였다. 

## 📡**Link**
- https://www.acmicpc.net/problem/21278
