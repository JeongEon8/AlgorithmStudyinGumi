# [백준 - g4] 1647. 도시 분할 계획

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그래프 이론
- 최소 스패닝 트리

## :round_pushpin: **Logic**

최소스패닝 트리를 크루스칼 알고리즘으로 만들되 두 그룹으로 나눠야하므로 마지막 간선을 포함하지 않으면 된다.

```java
	int result = 0;
		int count = 0;
		if(N!=2) {
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;

					if (++count == N - 2) {
						break;
					}
				}
			}
		}
```

## :black_nib: **Review**

수업에서 최소스패닝 트리를 구현한는데 disjoint부분을 혼자 구현하기가 힘들어서 연습할 겸 풀어 보았다.  
개념적으론 이해하는데 구현할때 이상하게 틀리거나 해매서 몇 문제 더 풀어봐야겠다.

## 📡**Link**

https://www.acmicpc.net/problem/1647
