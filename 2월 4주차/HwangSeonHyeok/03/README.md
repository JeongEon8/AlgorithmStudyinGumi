# [백준 - S3] 9715. Surface Area

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 기하학
- 3차원 기하학

## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**
밑면의 블록을 세어 겉넓이 위아래의 면의 겉넓이를 세어주고 각각의 블록을돌면서 동서남북으로 노출된 면을세어 겉널비을 구한다.
```java
int ans = 0;
for(int i= 1; i<=r;i++){
	String line = in.readLine();
	for(int j = 1; j<=c;j++){
		blocks[i][j] = line.charAt(j-1) - '0';
		if(blocks[i][j]>0)ans++;
	}
}
ans*=2;
for(int i= 1; i<=r;i++){
	for(int j = 1; j<=c;j++){
		ans+=Math.max(blocks[i][j]-blocks[i][j-1],0);
		ans+=Math.max(blocks[i][j]-blocks[i][j+1],0);
		ans+=Math.max(blocks[i][j]-blocks[i-1][j],0);
		ans+=Math.max(blocks[i][j]-blocks[i+1][j],0);
	}
}
```

## :black_nib: **Review**
영어문제 안나오게 설정했는데 왜 나오지  
문제 설명 그림이 예전에 풀어본 문제랑 비슷해서 그냥 풀어 보았다  
그리고 계산하는 부분 저렇게 하지말고 dx dy사용해서 4회반복 for문 돌리는게 더 이뻤을거 같다.

## 📡**Link**

https://www.acmicpc.net/problem/9715
