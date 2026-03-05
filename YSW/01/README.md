# [백준 - S1] 20364. 부동산 다툼 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 트리

## ⏲️**Time Complexity**

$O(Q*logN)$

## :round_pushpin: **Logic**

이진 트리 형태의 땅에서 원하는 땅까지 이동할 때, 경로에 이미 점유된 땅이 있는지 확인하는 문제입니다.
각 땅의 번호가 K일 때 부모 노드는 K / 2가 되므로, 특정 땅에서 루트까지의 경로는 반복적으로 2로 나누는 방식으로 쉽게 추적할 수 있습니다.
이를 이용해 다음과 같은 방식으로 해결했습니다.
우선 각 땅의 점유 여부를 저장하기 위해 boolean[] ground 배열을 사용했습니다.
각 오리에 대해 원하는 땅 target이 주어지면, 해당 땅에서 시작하여 target -> target/2 -> target/4 -> ... -> 1과 같이 루트 방향으로 이동하며 경로상의 땅을 확인합니다.
이 과정에서 이미 점유된 땅이 발견되면 해당 땅을 firstBlocked 변수에 기록합니다.
루트까지 탐색이 끝난 뒤에도 firstBlocked가 0이라면 경로에 점유된 땅이 없다는 의미이므로, 해당 오리는 원하는 땅을 차지할 수 있고 ground[target] = true로 점유 상태를 표시합니다.
반대로 firstBlocked가 0이 아니라면 경로 중에 이미 점유된 땅이 존재하는 것이므로, 그 값을 그대로 출력합니다.
이 과정을 모든 오리에 대해 반복하여 각 오리가 원하는 땅을 가질 수 있는지, 또는 처음으로 마주치는 점유된 땅의 번호를 구했습니다.

```java
		for (int i = 0; i < Q; i++) {
			int target = Integer.parseInt(br.readLine());
			int route = target;
			int firstBlocked = 0;
			while (route > 0) {
				if (ground[route]) {
					firstBlocked = route;
				}
				route /= 2;
			}

			if (firstBlocked == 0) {
				ground[target] = true;
			}
			sb.append(firstBlocked).append("\n");
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/20364
