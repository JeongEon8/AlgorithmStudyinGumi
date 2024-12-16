# [백준 - S4] 11652. 카드

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

정렬을하고 연속으로 가장 많이 나온 수를 찾는다.

```java
Arrays.sort(arr);
int max = 1;
long ans = arr[0];
int cnt = 1;
for(int i = 1; i<n;i++ ) {
	if(arr[i]!=arr[i-1]) {
		if(cnt>max) {
			max = cnt;
			ans = arr[i-1];
		}
		cnt=0;
		
	}
	cnt++;
}
if(cnt>max) {
	ans = arr[n-1];
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11652
