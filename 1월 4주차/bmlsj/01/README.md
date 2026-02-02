# [백준 - S3] 1002. 터렛

## ⏰ **time**

60분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- `sum`: 두 반지름의 합의 제곱 => 외접
- `diff`' : 두 반지름의 차의 제곱 => 내접

1. 두 원의 중심이 같고 반지름이 같을 경우 => 교점이 무한 개이므로 `-1`
2. 두 원이 너무 멀리 떨어져있거나 한 원이 다른 원 안에 있어 만나지 않을 때 => 교점이 `0`개
3. 외접이나 내접일 경우 => 교점 `1`개
4. 두 원이 두 점에서 교차할 때 => 교점 `2`개

```java
static void dir(int x1, int y1, int r1, int x2, int y2, int r2) {

	long dx = x1 - x2;
	long dy = y1 - y2;
	long d = dx * dx + dy * dy; // 거리의 제곱

	long sum = (long) (r1 + r2) * (r1 + r2);
	long diff = (long) (r1 - r2) * (r1 - r2);

	if (d == 0 && r1 == r2) {
		System.out.println(-1);
	} else if (d > sum || d < diff) {
		System.out.println(0);
	} else if (d == sum || d == diff) {
		System.out.println(1);
	} else {
		System.out.println(2);
	}
}
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/1002](https://www.acmicpc.net/problem/1002)