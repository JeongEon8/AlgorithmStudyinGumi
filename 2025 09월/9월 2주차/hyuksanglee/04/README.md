
# [백준- G5] 2447. 별 찍기 - 10
## ⏰  **time**
60분

## :pushpin: **Algorithm**
재귀

## ⏲️**Time Complexity**
$O(nlog3​8)$

## :round_pushpin: **Logic**

- 재귀로 3배수만큼 잘라서 탐색하는데 중간값은 패스
	- for문으로 0~3까지 돌는데 1이되면 패스
 	- 나머지는 재귀 호출
  - n/3 == 1이 될때까지 재귀 돌린다

```java
	static void dfs(int startY,int startX, int n) {
		if(n==1) {
			for(int i =0; i<3;i++) {
				for(int j =0; j<3; j++) {
					if(i==1&& j==1) {
						continue;
					}
					arr[startY+i][startX+j]=1;
				}
			}
			return;
		}else {
			for(int y =0; y<3; y++) {
			    for(int x = 0; x<3; x++ ) {
			        if(x==1 && y==1) {
			            continue;
			        }
			        if(startY+y*n<N && startX+x*n<N)
			        dfs(startY+y*n,startX+x*n,n/3);
			    }
			}
		}
		
	}
```

- 출력 시간 줄이기 위해 StringBuilder 사용
  ```java
  StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] == 1 ? '*' : ' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
  ```

## :black_nib: **Review**
- 이거 그냥 출력하면 시간초과 뜨고 StringBuilder 써야하더라구요


## 📡**Link**
- https://www.acmicpc.net/problem/2447

