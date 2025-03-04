# [백준 - 실버 1] 17615. 볼 모으기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 빨간 공, 파란 공의 묶음을 세어준다.
2. 파란 공 or 빨간 공이 왼쪽 or 오른쪽으로 이동하는 것이 모든 경우의 수
3. 가장 왼쪽, 오른쪽 묶음이 어떤 색인지 판단하고
4. 모든 경우의 수를 세어준다
```java
if(balls.charAt(0)=='R') {
			for(int i=1; i<reds.size(); i++) {
				tmp+=reds.get(i);
			}
			if(tmp<answer)answer=tmp;
			tmp=0;
		}
		
		if(balls.charAt(0)=='B') {
			for(int i=1; i<blues.size(); i++) {
				tmp+=blues.get(i);
			}
			if(tmp<answer)answer=tmp;
			tmp=0;
		}
		
		if(balls.charAt(balls.length()-1)=='B') {
			for(int i=0; i<blues.size()-1; i++) {
				tmp+=blues.get(i);
			}
			if(tmp<answer)answer=tmp;
			tmp=0;
		}
		
		if(balls.charAt(balls.length()-1)=='R') {
			for(int i=0; i<reds.size()-1; i++) {
				tmp+=reds.get(i);
			}
			if(tmp<answer)answer=tmp;
			tmp=0;
		}
```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/17615
