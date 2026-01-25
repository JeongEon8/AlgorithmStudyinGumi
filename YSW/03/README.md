# [백준 - S3] 4159. 알래스카 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**

주유소의 위치를 정렬하고 현재 위치부터 다음 주유소까지의 거리가 200이 넘지 않는다면 
다음 주유소로 이동 할 수 있기 때문에 lastPos을 다음 주유소 위치로 바꿔주고, 
200이 넘어서 마지막 주유소 까지 가지 못한다면 IMPOSSIBLE을 출력한다. 
마지막 주유소까지 간다음 목적지 델타 정션까지의 거리가 100을 넘기지 않는다면 POSSIBLE 넘긴다면 출발지 더슨 크릭으로 돌아갈 수 없기때문에 IMPOSSIBLE을 출력한다.

```java
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				return;
			}

			int[] map = new int[n];
			for (int i = 0; i < n; i++) {
				map[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(map);

			boolean flag = true;
			int lastPos = 0;
			for (int i = 1; i < n; i++) {
				if (map[i] > lastPos + 200) {
					flag = false;
					break;
				} else {
					lastPos = map[i];
				}
			}

			int distToFinish = 1422 - lastPos;
			if (distToFinish > 100) {
				flag = false;
			}

			System.out.println(flag ? "POSSIBLE" : "IMPOSSIBLE");
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/4159
