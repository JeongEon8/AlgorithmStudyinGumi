# [SWEA - D6] 1855. 영준이의 진짜 BFS

## ⏰ **time**

5시간

## :pushpin: **Algorithm**

- bfs
- LCA

## ⏲️**Time Complexity**

$O(T⋅NlogN)$

## :round_pushpin: **Logic**

- bfs를 사용하여 큐에 해당 숫자를 담는다.
 - 그리고 현제노드에서 다음 노드까지의 이동거리를 구하기 위해 LCA+DP 알고리즘 사용
   	- LCA+DP 알고리즘 : 희소 테이블을 활용하여 해당 노드를 2제곱을 하여 탐색하는 방식으로 일반 탐색보다 빠르다.
   	   	- 희소 테이블 : 테이블 0열에는 해당 노드의 부모를 작성, 1열에는 0열에 해당되는 부모작성, 2열에는 1열에 해당되는 부모 logN까지 작성
```java
	for (int i = 1; i <= N; i++) {
		        sparseTable[i][0] = pa[i]; // 2^0 번째 부모는 바로 부모
		    }

		    for (int j = 1; j < LOG; j++) {
		        for (int i = 1; i <= N; i++) {
		            if (sparseTable[i][j - 1] != 0) {
		                sparseTable[i][j] = sparseTable[sparseTable[i][j - 1]][j - 1];
		            }
		        }
		    }
```
```java
	public static long LCA(int curr, int next) {
		
		if(de[curr]<de[next]) {
			int temp = curr;
			curr = next;
			next = temp;
		}
		
		int dif = de[curr]-de[next];
		long count = 0;
		
		for(int i= LOG; i>=0; i--) {
			if(dif>=1 << i) {
				curr= sparseTable[curr][i];
				dif-=1 << i;
				count+=1 << i;
			}
		}
		
		
		 // 2. 공통 조상을 찾음
        if (curr == next) return count;

        for (int i = LOG; i >= 0; i--) {
            if (sparseTable[curr][i] != sparseTable[next][i]) {
                count += (1 << i) * 2;
                curr = sparseTable[curr][i];
                next = sparseTable[next][i];
            }
        }

        // 3. 마지막으로 부모 노드로 이동
        return count + 2;
	}
```

## :black_nib: **Review**
- LCA 이해하는데 진짜 오래걸렸어요
- 특히 희귀테이블을 이해하는게 제일 오래걸렸어요

## 📡**Link**

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LnipaDvwDFAXc&categoryId=AV5LnipaDvwDFAXc&categoryType=CODE&problemTitle=%EC%98%81%EC%A4%80%EC%9D%B4&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
