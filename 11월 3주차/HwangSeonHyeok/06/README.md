# [백준 - G5] 19951. 태상이의 훈련소 생활

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 누적 합

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
차이를 저장하는 diff 배열에서 높이의 변화가 시작해야하는 a인덱스에선 변화값만큼 더해주고 변화가 끝나는 b인덱스 + 1에선
변화값만큼 -해준다. index 0부터 변화량을 누적해가면 변화가 시작된 부분부터 끝나는부분까진 변화량만큼+ 그리고 b+1지점에선 다시 -가 돼서 여러 범위의 작업에 대해서도 답을 구할 수 있다.

```java
	for (int i = 0; i < m; i++) {
			split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			int diff = Integer.parseInt(split[2]);
			diffArr[start] += diff;
			if (end + 1 <= n)
				diffArr[end + 1] -= diff;
		}
		int diff = 0;
		for (int i = 1; i <= n; i++) {
			diff += diffArr[i];
			sb.append(diff + arr[i] + " ");
		}

```

## :black_nib: **Review**

특정 범위의 변화량을 기록하고 누적합을 이용해서 답을 구하는 독특한 문제였다.

## 📡**Link**

https://www.acmicpc.net/problem/19951
