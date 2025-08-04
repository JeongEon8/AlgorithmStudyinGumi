# [백준- S3] 18429. 근손실
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N!)$

## :round_pushpin: **Logic**
- DFS로 모든 조합을 순회하며 백트래킹
  
```java
 static void dfs(int depth) {
		if(depth==n) {
			answer++;
			return;
		}
		
		weight-=minus;
		for(int i=0; i<n; i++) {
		    if(!done[i]){
		        weight+=kits[i];
    		    if(weight>=500) {
    				done[i]=true;
    				dfs(depth+1);
    				done[i]=false;
    			}    
    			weight-=kits[i];
		    }
		}
		weight+=minus;
	}
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/18429
