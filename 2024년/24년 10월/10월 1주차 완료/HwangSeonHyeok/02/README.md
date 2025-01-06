# [백준 - S5] 30923. 크냑과 3D 프린터

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 기하학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

n=1일땐 6면체 하나의 겉넓이를 구하고 n>1에선 처음 직육면체와 마지막 직육면체만 예외를 두고 좌우에 노출된 겉넓이+4면의 겉넓이를 계산한다.

```java
	long ans = 0;
	if(n==1) {
		ans+=arr[0]*4+2;
	}else {
		ans+=arr[0]*3+Math.max(arr[0]-arr[1],0)+2;
		for(int i = 1; i<n-1; i++) {
			ans+=arr[i]*2+Math.max(arr[i]-arr[i+1],0)+Math.max(arr[i]-arr[i-1],0)+2;
		}
		ans+=arr[n-1]*3+Math.max(arr[n-1]-arr[n-2],0)+2;
	}
```

## :black_nib: **Review**

n이 1일때를 예외를 생각하지 않았다..

## 📡**Link**

https://www.acmicpc.net/problem/30923
