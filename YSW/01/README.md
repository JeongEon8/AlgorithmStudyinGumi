# [백준 - S1] 32337. 제비 통신 (Hard)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 자료 구조
- 기하학
- 조합론
- 집합과 맵
- 해시를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(M*N)$

## :round_pushpin: **Logic**

제비들의 기울기가 주어지고  한양이와 세종이의 좌표를 정했을때 제비들의 기울기에 있는 경우가 몇개 인지 확인하는 문제였다.
y = ax + b -> b = y - ax 
제비들의 기울기로 각 좌표들의 y절편을 구했을때 y절편이 같다면 두 좌표를 지나는 직선의 기울기가 제비의 기울기에 해당한다고 판단한다.
제비의 기울기에 해당하는 각 좌표들의 y절편을 구해서 해쉬맵에 y절편과 개수를 카운팅한다.
y절편의 카운팅된 개수로 제비들의 기울기에 있는 경우의수가 몇개인지 계산해서 더해준다.
제비들의 기울기 개수만큼 반복해서 제비들의 기울기에 있는 경우의수를 구해준다.

```java
		for (int i = 0; i < M; i++) {
			int slope = slopes[i];
			for (int j = 0; j < N; j++) {
				int x = nodes[j].x;
				int y = nodes[j].y;
				long b = (long) y - (long) slope * x;
				if (hashmap.containsKey(b)) {
					hashmap.put(b, hashmap.get(b) + 1);
				} else {
					hashmap.put(b, 1);
				}
			}

			for (int n : hashmap.values()) {
				count += (long) n * (long) (n - 1);
			}

			hashmap.clear();
		}
```

## :black_nib: **Review**

처음에 좌표들로 조합을 만들어서 기울기가 제비들의 기울기에 해당하는지로 코드로 작성했는데 시간초과가 났다. 그리고 y절편으로 하는 방법으로 바꿨는데 해당하는 개수와 y절편 등 여러 변수들의 형식을 long으로 형변환을 하지 않아서 결과가 틀린경우가 있어서 여러번의 시행착오가 있었다.

## 📡**Link**

https://www.acmicpc.net/problem/32337
