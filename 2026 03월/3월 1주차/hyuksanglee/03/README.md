# [백준 - 실버 2] 21736. 헌내기는 친구가 필요해

## ⏰**time**

20분

## :pushpin: **Algorithm**

dfs

## ⏲️**Time Complexity**

$O(N x N)$

## :round_pushpin: **Logic**

1.  I 좌표에서 dfs로 탐색하여 P를 찾은 개수를 체크후 0이면 TT, 아니면 찾은 수를 출력해준다.
   ```java
static void dfs(char[][] list, int i, int j) {
		
		if(list[i][j]=='P') {
			result++;
		}
		
		for(int d = 0; d<4; d++) {
			int ci = i + di[d];
			int cj = j + dj[d];
			if(ci<0 || ci>=N || cj <0 || cj >=M) {
				continue;
			}
			
			if(!check[ci][cj] && list[ci][cj]!='X') {
				check[ci][cj] = true;
				
				dfs(list,ci,cj);
			}
		}
		return ;
	}

	if(result ==0) {
			System.out.println("TT");
		}else {
			System.out.println(result);
		}
```


## :black_nib: **Review**


## 📡 Link

<https://www.acmicpc.net/problem/21736>
