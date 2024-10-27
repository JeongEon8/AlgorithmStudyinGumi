# [백준 - S2] 18113. 그르다 김가놈

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 이분 탐색
- 매개 변수 탐색

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

김밥의 꼬다리는 입력받을때 처리한다.

```java
	for (int i = 0; i < n; i++) {
			int kimbap = Integer.parseInt(in.readLine());
			if (kimbap > 2 * k) {
				kimbap -= 2 * k;
			} else if (kimbap == 2 * k) {
				continue;
			} else if (kimbap > k) {
				kimbap -= k;
			} else {
				continue;
			}
			kimbaps.add(kimbap);
		}
```

이분 탐색으로 김밥 M개로 자를 수 있는 최대 길이 P를 찾는다.

```java
int left = 1;
int right = 1000000000;
while (left < right) {
	int mid = (left + right) / 2;
	int cnt = 0;
	for (int kimbap : kimbaps) {
		cnt += kimbap / mid;
	}
	if (cnt >= m) {
		left = mid + 1;
	} else {
		right = mid - 1;
	}
}
int cnt = 0;
for (int kimbap : kimbaps) {
	cnt += kimbap / left;
}
if (cnt >= m) {
	System.out.println(left);
} else {
	if (left - 1 > 0)
		System.out.println(left - 1);
	else {
		System.out.println(-1);
	}
}
```

## :black_nib: **Review**

꼬다리 부분을 제외하면 비슷한 이분탐색 문제를 많이 본듯하다.

## 📡**Link**

https://www.acmicpc.net/problem/18113
