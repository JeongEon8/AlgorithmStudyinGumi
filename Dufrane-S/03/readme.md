# [백준 - S4] 20125. 쿠키의 신체 측정

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 머리가 가장 위이므로 머리 좌표 찾기
2. 나머지 부분 구하기

```java
int leftHand =0;
		int x = core.x-1;
		char now='*';
		while(now=='*'){
		    leftHand++; 
		    x--;
		    if(x==-1)break;
		    now = list[core.y][x];
		}
		System.out.print(leftHand+" ");
...
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/20125
