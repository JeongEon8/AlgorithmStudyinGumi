# [백준- G4] 2293. 동전1
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(n·k)$
n: 동전의 종류, k : 만들어야하는 돈
- 동전 작은거 부터 1~k 까지 몇개를 들어가는지 채워준다
	- 동전 3이면 3 : 1 , 6: arr[6-3] = 6:1 이런식으로 채워준다.
 	- 제일 작은 동전이 3 인데 4를 만들려면 4-3 =1 로 만들수 없으면 넘겨 준다.
	
```java
   for(int j = 0; j<n; j++) {
			for(int i = 1; i<k+1; i++) {
				if(i- cachs[j] ==0) {
					arr[i]+=1;
				}else if(i- cachs[j] >0 && arr[i- cachs[j]]>0) {
					arr[i]+=arr[i- cachs[j]];
				}
			}
		}
```

## :black_nib: **Review**
예전에는 dp가 어려웠는데 이제는 dp가 코드 적기 편해서 더 좋아요

## 📡**Link**
- https://www.acmicpc.net/problem/2293
