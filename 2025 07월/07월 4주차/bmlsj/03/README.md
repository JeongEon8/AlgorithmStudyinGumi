# [백준 - G4] 1043. 거짓말
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
DFS / 유니온 파인드

## ⏲️**Time Complexity**
$O(N^2)$ / $O(N)$

## :round_pushpin: **Logic**

### 1. DFS 풀이

1. 먼저 진실은 아는 사람을 모두 `visited[] = true`로 설정
2. 파티에 같이 가는 사람들끼리 연결해준다. => `graph`
3. 만약 `visited`가 `true`인 사람들과 연결되어 있다면, 마찬가지로 `visited`를 `true`로 설정해준다.
  => `party` 함수의 역할
4. 파티별로 `visited`가 `true`인 사람이 있는지 확인해주기 위해, 미리 저장해준 파티 정보 `parties`에서 `visited`를 확인한다.
    - 여기서 한명이라도 `true`이면, `ans -= 1`를 실행
    - `ans` : 참석할 수 있는 파티 수

```java
for (int i = 0; i < M; i++) {
	for (int num : parties[i]) {
		if (visited[num]) {
			ans--;
			break;
		}
	}
}

static void party(int person) {

	if (visited[person]) {
	for (int next : graph[person]) {
		if (!visited[next]) {
			visited[next] = true;
			party(next);
		}
	}
}
```


### 2. Union-Find 풀이

1. 진실을 아는 사람들을 `truth` 배열에 저장한다.
2. 각 파티마다 참가자들을 `union`한다.
3. 각 파티에서 참가자 중 진실을 아는 사람과 같은 그룹에 속한 사람이 있으면 => `ans--`
4. 그렇지 않으면 거짓말 가능

```java
// 파티 참가자 저장
List<int[]> parties = new ArrayList<>();
for (int i = 0; i < M; i++) {
	split = br.readLine().split(" ");
	int[] party = new int[Integer.parseInt(split[0])];
	for (int j = 0; j < party.length; j++) {
		party[j] = Integer.parseInt(split[j + 1]);
	}

	// union: 파티 내 사람 연결
	for (int j = 0; j < party.length - 1; j++) {
		union(party[j], party[j + 1]);
	}

	parties.add(party);
}

int ans = M;
for (int[] party : parties) {
	boolean check = false;
	for (int person : party) {
		for (int t : truth) {
			if (find(person) == find(t)) {
				ans--;
				check = true;
				break;
			}
		}

		if (check) {
			break;
		}
	}
}

static void union(int u1, int u2) {

	int a = find(u1);
	int b = find(u2);

	if (a > b) {
		parent[a] = b;
	} else {
		parent[b] = a;
	}
}

static int find(int u) {

	if (parent[u] != u) {
		parent[u] = find(parent[u]);
	}
	return parent[u];
}
```


## :black_nib: **Review**
- 코드가 꼬질꼬질.. 😂
- union-find 때문에 무조건 더 작은 노드를 부모로 가지게 되서, `truth`의 부모와 파티 참가자들의 부모 노드를 비교해주어야 한다.

## 📡**Link**
- https://www.acmicpc.net/problem/1043
