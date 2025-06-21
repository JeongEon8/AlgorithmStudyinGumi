# [백준- S4] 1018. 체스판 다시 칠하기
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- 체스판의 왼쪽 위가 W인 경우를 구하고 64에서 빼주면 B인 경우
  
```java
static int check(char [][]board, int y, int x) {
		int count=0;
        for(int i=y;i<y+8;i+=2){
            for(int j=x;j<x+8;j+=2){
                if(board[i][j]=='W'){
                    count++;
                }
            }
            for(int j=x+1;j<x+8;j+=2){
                if(board[i][j]=='B'){
                    count++;
                }
            }
        }
        for(int i=y+1;i<y+8;i+=2){
            for(int j=x;j<x+8;j+=2){
                if(board[i][j]=='B'){
                    count++;
                }
            }
            for(int j=x+1;j<x+8;j+=2){
                if(board[i][j]=='W'){
                    count++;
                }
            }
        }
		return count<64-count?count:64-count;
	}
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1018
