# [백준 - 실버 3] 1018. 체스판 다시 칠하기

## ⏰**time**

60분

## :pushpin: **Algorithm**

dfs

## ⏲️**Time Complexity**

$O(N x N)$
N: 세로길이, M: 가로길이

## :round_pushpin: **Logic**

1.  체스판을 8칸씩 끊어서 먼저 (1,1) 에 W시작했을때 칠해야하는 수를 구하고 B일경우는 64에서 빼주었다
2.  최소로 칠할수 있는 값을 뽑아준다.
   ```java
static int dfs(String[] list, int count, int i, int j) {
		for(int n =i; n< i+8; n++) {
			if(n%2==0) {
				for(int m =j; m<j+8; m++) {
					char c = list[n].charAt(m);
					if(m%2==0 && list[n].charAt(m)!='W') {
						count++;
					}
					if(m%2!=0 && list[n].charAt(m)!='B') {
						count++;
					}
				}
			}else {
				for(int m =j; m<j+8; m++) {
					if(m%2!=0 && list[n].charAt(m)!='W') {
						count++;
					}
					if(m%2==0 && list[n].charAt(m)!='B') {
						count++;
					}			
										
									
				}
			}
		}
		
		return count;
	}
```


## :black_nib: **Review**


## 📡 Link

<https://www.acmicpc.net/problem/1018>
