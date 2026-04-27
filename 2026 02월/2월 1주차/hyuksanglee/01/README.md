# [백준 - G5] 20055. 컨베이어 벨트 위의 로봇

## ⏰ **time**

90분

## ⏲️**Time Complexity**

$O(N × K)$

- N : 컨베이어 수
- K : 최대 0의 개수
## :round_pushpin: **Logic**

1. 내구도를 하나씩 넣어준다.
```java
   input =in.readLine().split(" ");
		for(int i =0; i<2*N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
```
2. 먼저 내구도와 로봇 한바퀴 돌려준다.
 ```java
   boolean temN = check[2*N-1];
			for(int i =2*N-1; i>0; i--) {
				check[i]=check[i-1];
			}
			check[0]= temN;
			
			int temM = arr[2*N-1];
			for(int i =2*N-1; i>0; i--) {
				arr[i]=arr[i-1];
			}
			arr[0]= temM;
			
```
3. 첫번쨰 칸이랑 n-1칸 비워준다.
```java
         check[0]=false;
			check[N-1]=false;
```
4. 로봇을 옆에 비어있으면 이동시켜주고 그 칸이 n-1이면 비워준다.
```java
			for(int i =N-2; i>=0; i--) {
				if( check[i] && check[i+1]==false && arr[i+1]>0) {
					check[i]=false;
					check[i+1]=true;
					arr[i+1]--;
				}
				check[N-1]=false;
			}
```
5. 첫번째 칸이 내구도가 있으면 로봇을 생성 한다.
```java
	if(arr[0]>0) {
				arr[0]--;
				check[0] = true;
			}
```
   
6. 내구도가 0인게 k 될때까지 돌려준다.
```java
   while(count<K) {
   ~~~~~

   count =0;
			 for (int i = 0; i < 2 * N; i++) {
	                if (arr[i] == 0) {
	                    count++;
	                }
	            }
```


## :black_nib: Review
- 너무 어려운거 골랐어요
- 처음에는 index 값을 만들어서 그것만 돌릴려고 했는데 안되더라구요
## 📡**Link**

- [https://www.acmicpc.net/problem/20055](https://www.acmicpc.net/problem/20055)
