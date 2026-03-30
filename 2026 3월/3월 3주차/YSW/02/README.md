# [백준 - S1] 1711. 직각삼각형 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 브루트포스 알고리즘
- 기하학
- 피타고라스 정리

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

점들의 좌표가 주어지고 좌표들로 직삼각형을 몇개나 만들 수 있는지 개수를 구하는 문제였다.
좌표 3개를 선정하고 이은 선의 길이가 피타고라스 정리를 만족하는지 확인하고 만족하면 count를 증가시켜서 직삼각형의 개수를 구했다.

```java
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					long d1 = getDistSq(points[i], points[j]);
					long d2 = getDistSq(points[i], points[k]);
					long d3 = getDistSq(points[j], points[k]);

					if (d1 + d2 == d3 || d1 + d3 == d2 || d2 + d3 == d1) {
						count++;
					}
				}
			}
		}

	public static long getDistSq(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1711
