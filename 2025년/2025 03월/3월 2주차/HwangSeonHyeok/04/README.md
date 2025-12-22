# [백준 - G5] 1548. 부분 삼각 수열

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 브루트포스 알고리즘
- 정렬
- 투 포인터

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
수열에 들어간 가장 작은 수 둘의 합이 가장 큰 수 보다 크면 그 수열은 부분 삼각 수열이다.  
정렬해서 수열에 포함된 가장 작은 수 둘을 더하고 새로 들어올 가장 큰 수의 삼각관계를 확인한다. 만약 성립하지 않는다면 작은쪽 수들을 삼각 수열이 될때까지 빼준다.
```java
Arrays.sort(arr);
int ans = 2;
if (n < 3) {
	ans = n;
} else {
	int left = 0;
	for (int i = 2; i < n; i++) {
		if (arr[left] + arr[left + 1] <= arr[i]) {
			ans = Math.max(ans, i - left);
			while (left < i - 1) {
				left++;
				if (arr[left] + arr[left + 1] > arr[i])
					break;
			}
		}
	}
	ans = Math.max(ans, n - left);
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1548
