# [백준 - S1] 25633. 도미노 넘어뜨리기 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 그리디 알고리즘
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

각 도미노를 시작점으로 가정하고, 해당 위치에서 연쇄적으로 몇 개의 도미노를 쓰러뜨릴 수 있는지 계산하는 문제입니다.

i번째 도미노를 처음 넘어뜨린다고 가정한 뒤, 현재까지 쓰러진 도미노의 누적 무게를 currentWeight에 저장하고, 쓰러진 도미노 개수를 count로 관리합니다.

이후 뒤에 있는 도미노들을 순차적으로 확인하면서 현재 누적 무게가 다음 도미노의 무게 이상이면 연쇄적으로 쓰러뜨릴 수 있습니다. 도미노를 쓰러뜨릴 때마다 누적 무게에 해당 무게를 더하고,
개수를 1 증가시킵니다.

각 시작점마다 가능한 최대 연쇄 개수를 계산하고, 그 중 최댓값을 최종 결과로 반환합니다.

```java
		int maxDominoes = 1;
		for (int i = 0; i < n - 1; i++) {
			int currentWeight = dominoWeights[i];
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (currentWeight >= dominoWeights[j]) {
					currentWeight += dominoWeights[j];
					count++;
				}
			}
			if (maxDominoes < count) {
				maxDominoes = count;
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25633
