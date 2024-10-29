# [백준 - G3] 2473. 세 용액

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 정렬
- 이분 탐색
- 투 포인터

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

선택한 용액을 가장 작은거부터 용액 1, 2, 3이라 할때 용액 1을 선형적으로 순서대로 하나를 고르고 2 3을 1 다음 용액 3을 가장 ph가 큰 용액으로 잡고 투포인터를 이용해서 선택하고 ph의 절대값이 가장 작은 경우를 찾으면 된다.

```java
static void solution() {
	for (int i = 0; i < n - 2; i++) {
		long p1 = liquids[i];
		int left = i + 1;
		int right = n - 1;
		while (left < right) {
			Long ph = p1 + liquids[left] + liquids[right];
			if (ph == 0) {
				ans1 = p1;
				ans2 = liquids[left];
				ans3 = liquids[right];
				return;
			}
			if (Math.abs(ph) < absMinPh) {
				absMinPh = Math.abs(ph);
				ans1 = p1;
				ans2 = liquids[left];
				ans3 = liquids[right];
			}
			if (ph < 0) {
				left++;
			} else {
				right--;
			}
		}
	}

}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2473
