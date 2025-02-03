# [백준 - S3] 20126. 교수님의 기말고사

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
시작시간을 기준으로 정렬하고 0부터 시작해서 각 시험의 종료시간 ~ 다음 시험의 시작시간 최종적으로 시간 S까지 해서 시험을 치룰 시간이 있는 부분을 찾아준다.
```java
Arrays.sort(arr);
int ans = 0;
if (arr[0].x >= m) {
	System.out.println(0);
} else {

	for (int i = 1; i < n; i++) {
		if (arr[i].x - (arr[i - 1].x + arr[i - 1].y) >= m) {
			ans = arr[i - 1].x + arr[i - 1].y;
			break;
		}
	}
	if (ans == 0) {
		if (s - (arr[n - 1].x + arr[n - 1].y) >= m) {
			System.out.println(arr[n - 1].x + arr[n - 1].y);
		} else {
			System.out.println(-1);
		}
	} else {
		System.out.println(ans);
	}
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/20126
