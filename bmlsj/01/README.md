
# [백준- G2] 4195. 친구 네트워크

## ⏰  **time**
60분

## :pushpin: **Algorithm**
union-find

## ⏲️**Time Complexity**
$O(1)$

## :round_pushpin: **Logic**

1. 두 사람의 `root`를 비교해, 서로 다를 경우 둘을 합친다.
2. `size[a] < size[b]`일 경우 , 항상 `a`가 대표가 되게 하기 위해 둘의 값을 바꾼다.
3. 만약, swap을 하지 않으려면, 그때 그때 누가 대표가 될지 명시적으로 처리한다.


```java
for (int i = 0; i < F; i++) {
	String[] split = br.readLine().split(" ");
		for (int j = 0; j < split.length; j++) {

			// 친구 그래프에 아직 없을 경우, 추가
			if (!hash.containsKey(split[j])) {
				hash.put(split[j], idx++);
			}
		}

		int a = hash.get(split[0]);
		int b = hash.get(split[1]);

		// 네트워크 합치기
		System.out.println(union(a, b));

	}
}
```

```java
static int union(int a, int b) {

	a = find(a);
	b = find(b);

	if (a != b) {

		// 항상 큰 쪽을 대표로 삼음
		if (size[a] < size[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		parent[b] = a;
		size[a] += size[b];
	}

	return size[a];
}
```

## :black_nib: **Review**
- DFS로 풀었다가 시간초과를 맛봄 냠념
- 입력이 100,000 이기도 하고, 네트워크 수를 구할 때 마다 dfs를 실행해야하기 때문에 시간초과가 발생했다.
- 고로.. 왜 골드2인지 생각하기


## 📡**Link**
- https://www.acmicpc.net/problem/4195

