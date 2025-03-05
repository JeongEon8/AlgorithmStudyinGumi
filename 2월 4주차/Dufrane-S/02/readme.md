# [백준 - 실버 1] 16918. 봄버맨
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 실제 폭탄이 터지는 시뮬레이션을 구현
2. 또는 첫번째 설치한 폭탄 폭발, 폭탄 설치 ,두번째 설치한 폭탄 폭발의 반복이므로 시뮬레이션하지 않고 저장된 값을 보여줘도 됨
   
```java
public static void set(int [][] list,int time) {
		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
				if(list[i][j]==-1) {
					list[i][j]=time;
				}
			}
		}
	}
	public static void explode(int [][] list,int time) {
		int [][]copyList = new int[list.length][list[0].length];
		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
			    copyList[i][j]=list[i][j];
			}
		}

		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
				if(copyList[i][j]==time-3) {
					list[i][j]=-1;
					for(int k=0; k<4; k++) {
						int ny=i+dy[k];
						int nx=j+dx[k];
						if(ny<0||nx<0||ny>=list.length||nx>=list[0].length)continue;
						list[ny][nx]=-1;
					}
				}
			}
		}
	}
```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/16918
