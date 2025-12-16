# [백준 - S1] 32760. Nothing Everything (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 애드 혹
- 해 구성하기

## ⏲️**Time Complexity**

$O(N + M)$

## :round_pushpin: **Logic**

문제에서 Nothing 연산일 경우 자신보다 작은 하위 정점들과의 연결이 모두 없어야 한다. 해당 조건을 만족하면 N을 추가한다.
Everyting 연산일 경우 자신보다 작은 하위 정점들과의 연결이 모두 있어야 한다. 해당 조건을 만족하면 E을 추가한다.
모든 연산이 해당 조건중 하나라도 만족하지 못하면 -1을 출력한다.
각 정점들의 하위 정점과 연결한 개수를 저장할 배열을 만들고 하위 정점과 연결된 간선 수를 저장한다.
그런다음 해당 조건을 만족하는지 확인한다.

```java
		int[] cnt = new int[100001];
		for (int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int from = Integer.parseInt(inputs[0]);
			int to = Integer.parseInt(inputs[1]);
			if (from > to) {
				cnt[from]++;
			} else {
				cnt[to]++;
			}
		}

		for (int i = 2; i <= N; i++) {
			if (cnt[i] == 0) {
				sb.append("N");
			} else if (cnt[i] == i - 1) {
				sb.append("E");
			} else {
				System.out.println(-1);
				return;
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/32760
