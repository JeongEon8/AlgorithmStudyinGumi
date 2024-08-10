# [백준 - S5] 1010. 다리 놓기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(N)$


## :round_pushpin: **Logic**
- 점화식 : N2 : M3 에서 N2 : M4로 추가된 경우
-  N에서 2번째는 경우의 수가 2가지이다.
-   N2 -> M3과 N2 -> M4밖에 없다.
-   N2 -> M3 인 경우는 N2 : M3 경우의 수랑 같고
-   N2 -> M4 인 경우 N1 : M3 랑 경우의 수가 같다.
-   N2 : M4 = (N2 : N3) + (N1 : M3)
-   Na : Mb = ( Na : M(b-1) ) + ( N(a-1) : M(b-1) )
  
```java
		for(int i =2; i<30; i++) { 
			for(int j = i+1; j<30; j++) {
				arr[i][j]=arr[i][j-1] + arr[i-1][j-1];
			}
		}
```

## :black_nib: **Review**
- 코드를 작성하는데는 얼마 안걸렸는데 점화식을 찾는데 시간을 너무 걸렸어요

  
## 📡**Link**

- https://www.acmicpc.net/problem/1010


  
