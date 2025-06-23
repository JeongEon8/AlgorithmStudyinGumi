# [백준- S3] 17484. 진우의 달 여행 (Small)
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
- dfs를 통해 가능한 모든 경우의 수를 탐색
  
```java
static void dfs(int y, int x, int beforeDir, int sum){
	    sum+=map[y][x];
	    if(sum>answer)return;
	    if(y==rows-1){
	        if(sum<answer)answer=sum;
	        return;
	    }
	    
	    for(int dir : nums){
	        if(dir==beforeDir)continue;
	        if(dir+x<0||dir+x>=columns)continue;
	        dfs(y+1,x+dir,dir,sum);
	    }
	}
	}
```

## :black_nib: **Review**
처음에는 dp로 접근했으나 연료가 같은 경우를 생각을 못해서 dfs로 변경
## 📡**Link**
- https://www.acmicpc.net/problem/17484
