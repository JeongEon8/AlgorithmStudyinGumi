# [백준 - S5] 30088. 공포의 면담실

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬
- 누적 합

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
각 부서별 총 면담 시간 합을 구하고 정렬해서 가장 시간이 적게드는 부서부터 면담을 진행하면 모든 부서의 퇴근 시간 합을 최소로 만들 수 있다.
```java
long ans = 0;
long[] department = new long[n];
for (int i = 0; i < n; i++) {
	String[] split = in.readLine().split(" ");
	int num = Integer.parseInt(split[0]);
	for (int j = 1; j <= num; j++) {
		department[i] += Long.parseLong(split[j]);
	}
}
Arrays.sort(department);
long prefixSum = 0;
for (long time : department) {
	prefixSum += time;
	ans += prefixSum;
}
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/30088
