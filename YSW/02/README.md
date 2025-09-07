# [백준 - S3] 27920. 카드 뒤집기 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 해 구성하기

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

카드의 번호만큼 이동했을때 카드를 뒤집기 때문에 N을 마지막에 하고 처음에 N-1 카드를 맨 오른쪽이나 왼쪽에 놓고 그다음 N-2 카드를 반대쪽의 끝쪽으로 이런식으로 채워 가면서 하면서 하는 식으로 작성했다.

```java
		for (int i = 1; i <= N; i++) {
			if (i == N) {
				if (i % 2 == 1) {
					numbers[index] = N;
				} else {
					numbers[N - index2] = N;
				}
			} else if (i % 2 == 1) {
				numbers[index++] = N - i;
			} else {
				numbers[N - index2++] = N - i;
			}
		}
		sb.append("YES\n");

		for (int i = 1; i < numbers.length; i++) {
			sb.append(numbers[i] + " ");
		}
		sb.append("\n");

		index = 1;
		index2 = 0;
		for (int i = 1; i <= N; i++) {
			if (i == N) {
				if (i % 2 == 1) {
					sb.append(index);
				} else {
					sb.append(N - index2);
				}
			} else if (i % 2 == 1) {
				sb.append(index++ + " ");
			} else {
				sb.append(N - index2++ + " ");
			}
		}
```

## :black_nib: **Review**

모든 카드를 뒤집을 수 있으면 Yes 아니면 No 인데 무조건 가능인거 같아서 Yes를 했다.

## 📡**Link**

https://www.acmicpc.net/problem/27920
