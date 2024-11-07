# [백준 - S2] 1183. 약속

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

정렬하고 가운데를 찾는 문제.  
기다리는 시간을 기준으로 정렬해야하므로 약속시간-도착시간을 기준으로 정렬하고 중간값을 답으로한다.

```java
	for(int i = 0; i<n;i++) {
		String[] split = in.readLine().split(" ");
		arr[i] = Integer.parseInt(split[0]) - Integer.parseInt(split[1]);
	}
	Arrays.sort(arr);
	int ans = arr[n/2]-arr[(n-1)/2]+1;

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1183
