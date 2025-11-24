# [백준 - S3] 25709. 1 빼기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

N에 1이 포함되어 있으면 1을 하나 제거 포함되어있지 않을 시 N의 값에서 -1을 하고 연산횟수를 1증가 시킨다. N이 0이 될때까지 반복하고 0이 되면 연산 횟수를 출력한다.

```java
		while (N != 0) {
			String strN = String.valueOf(N);
			if (strN.contains("1")) {
				int index = strN.indexOf('1');
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < strN.length(); i++) {
					if (i != index)
						sb.append(strN.charAt(i));
				}
				String resultStr = sb.toString().replaceFirst("^0+", "");
				N = resultStr.isEmpty() ? 0 : Integer.parseInt(resultStr);
			} else {
				N--;
			}
			count++;
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25709
