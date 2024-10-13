# [백준 - S3] 1431. 시리얼번호

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

다음과 같은 serial 클래스를 만들고 정렬하고 순서대로 출력하면된다.

```java
static class Serial implements Comparable<Serial> {
		int sum = 0;
		String serial;

		public Serial(String serial) {
			super();
			this.serial = serial;
			for (int i = 0; i < serial.length(); i++) {
				int cNum = serial.charAt(i) - '0';
				if (cNum > 0 && cNum <= 9) {
					sum += cNum;
				}
			}
		}

		@Override
		public int compareTo(Serial o) {
			if (this.serial.length() != o.serial.length()) {
				return this.serial.length() - o.serial.length();
			} else if (this.sum != o.sum) {
				return this.sum - o.sum;
			}
			return this.serial.compareTo(o.serial);
		}

	}

```

## :black_nib: **Review**
요즘 알고리즘 풀 시간이 없어 날먹 문제만 풀고있다ㅠ

## 📡**Link**

https://www.acmicpc.net/problem/1431
