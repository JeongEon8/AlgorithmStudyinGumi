# [백준 - S2] 31462. 삼각 초콜릿 포장 (Sweet)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
위에서부터 아직 포장하지않은 빨강이 나오면 아래, 아래 오른쪽껄 파랑이 나오면 아래오른쪽, 오른쪽꺼도 같은색이어야한다. 중복사용하지 않게 그리디하게 모두 포장할 수 있으면 가능한 답이다.
```java
loop:for(int i = 0; i<n;i++){
	for(int j = 0; j<=i;j++){
		if(visit[i][j])continue;
		if(i+1==n){
			isAble = false;
			break loop;
		}
		if(tri[i][j]){
			if(j+1>i){
				isAble = false;
				break loop;
			}
			if(tri[i][j+1]&&tri[i+1][j+1]&&!visit[i][j+1]&&!visit[i+1][j+1]){
				visit[i][j]=true;
				visit[i][j+1]=true;
				visit[i+1][j+1]=true;
			}else{
				isAble = false;
				break loop;
			}
		}else{
			if(!tri[i+1][j]&&!tri[i+1][j+1]&&!visit[i+1][j]&&!visit[i+1][j+1]){
				visit[i][j]=true;
				visit[i+1][j]=true;
				visit[i+1][j+1]=true;
			}else{
				isAble = false;
				break loop;
			}
		}
	}
}
```

## :black_nib: **Review**
더 깔끔하게 풀 수 있을거 같은데 더럽게 풀렸다.

## 📡**Link**

https://www.acmicpc.net/problem/31462
