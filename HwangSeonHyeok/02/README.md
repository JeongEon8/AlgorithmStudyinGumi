# [백준 - S5] 11536. 줄 세우기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 문자열
- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
이전보다 문자보다 내림차순이면 -1 오름차순이면 +1을 해준다.  
모든 문자열을 돌고 계산결과가 n-1이면 오름차순, 1-n이면 내림차순이다.  
이외의 값이면 오름차순도, 내림차순도 아니다.
```java
	int mod = 0;
	for(int i = 1; i<n;i++) {
		if(arr[i].compareTo(arr[i-1])<0) {
			mod-=1;
		}else if(arr[i].compareTo(arr[i-1])>0) {
			mod+=1;
		}
	}
	if(mod==n-1) {
		System.out.println("INCREASING");
	}else if(mod==1-n) {
		System.out.println("DECREASING");
	}else {
		System.out.println("NEITHER");
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11536
