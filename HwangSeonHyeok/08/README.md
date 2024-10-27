# [백준 - S4] 16723. 원영이는 ZOAC과 영원하고 싶다

## ⏰ **time**

90분

## :pushpin: **Algorithm**

- 수학

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

$2^n$마다 주기가 반복되므로 2진수로 바꿔서 1이 나오면 그 자릿수가 될때까지의 2의 제곱수들을 더해준다.
이진수 bin을 뒤집고 0을 붙인건 계산할때 인덱스 계산하기 용이하기 위함.

```java
static long solve(int num) {
	long ans = 0;
	String bin = Integer.toBinaryString(num);
	StringBuffer sb = new StringBuffer(bin);
	bin = "0" + sb.reverse().toString();

	for (int i = 1; i < bin.length(); i++) {
		if (bin.charAt(i) == '1') {
			long tmp = 2;
			for (int j = 1; j < i; j++) {
				ans += tmp * Math.pow(2, (i - j - 1));
				tmp *= 2;

			}

			ans += tmp;
		}
	}

	return ans;

}

```

## :black_nib: **Review**

이거도 규칙을 노트에 적으면서 풀었다.

## 📡**Link**

https://www.acmicpc.net/problem/16723
