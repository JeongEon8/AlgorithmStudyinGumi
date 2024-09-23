# [백준 - g2] 7453. 합이 0인 네 정수

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 정렬
- 이분탐색
- 투 포인터
- 중간에서 만나기

## :round_pushpin: **Logic**

1, 2번자리의 합과 3, 4번자리의 합만 미리 계산한다.

```java
int[] abSum = new int[n * n];
for (int i = 0; i < n; i++) {
	int a = arr[i][0];
	for (int j = 0; j < n; j++) {
		int b = arr[j][1];
		int sum = a + b;
		abSum[i * n + j] = sum;
	}
}

int[] cdSum = new int[n * n];
for (int i = 0; i < n; i++) {
	int c = arr[i][2];
	for (int j = 0; j < n; j++) {
		int d = arr[j][3];
		int sum = c + d;
		cdSum[i * n + j] = sum;
	}
}
```

이를 오름차순으로 정렬하고 ab는 첫 index부터 cd는 마지막 index부터 순서대로 계산하면서 합이 0인 경우의 수를 찾는다.

```java
long ans = 0;
Arrays.sort(abSum);
Arrays.sort(cdSum);
int abIdx = 0;
int cdIdx = n * n - 1;
while (abIdx < n * n && cdIdx >= 0) {
	if (abSum[abIdx] + cdSum[cdIdx] == 0) {
		long abcnt = 1;
		long cdcnt = 1;
		boolean flag = true;
		while (flag) {
			if (abIdx + 1 < n * n && abSum[abIdx + 1] == abSum[abIdx]) {
				abcnt++;
				abIdx++;
			} else {
				flag = false;
			}
		}
		while (!flag) {
			if (cdIdx - 1 >= 0 && cdSum[cdIdx - 1] == cdSum[cdIdx]) {
				cdcnt++;
				cdIdx--;
			} else {
				flag = true;
			}
		}
		ans += abcnt * cdcnt;
		abIdx++;
		cdIdx--;
	} else if (-abSum[abIdx] > cdSum[cdIdx]) {
		abIdx++;
	} else {
		cdIdx--;
	}
}
```

## :black_nib: **Review**

처음엔 해시맵으로 0이되는 경우를 찾으려 했는데 테스트 케이스에 해시충돌로 시간초과가 발생하는 경우가 있는것 같다.

## 📡**Link**

https://www.acmicpc.net/problem/7453
