# [백준 - 골드 4] 20040. 사이클 게임

## ⏰**time**

25분

## :pushpin: **Algorithm**

- 유니온 파인드 (Disjoint Set Union)
- 사이클 판별

## ⏲️**Time Complexity**

$O(M)$

## :round_pushpin: **Logic**

1. 정점 개수 `n`에 대해 `parent[i] = i`, `size[i] = 1`로 초기화하여 서로소 집합을 구성합니다.

```java
parent = new int[n];
size = new int[n];
for (int i = 0; i < n; i++) {
    parent[i] = i;
    size[i] = 1;
}
```

2. `find` 연산은 경로 압축(Path Compression)을 이용해 루트 부모를 찾습니다.

```java
static int find(int x) {
    while (parent[x] != x) {
        parent[x] = parent[parent[x]];
        x = parent[x];
    }
    return x;
}
```

3. `union(a, b)`에서 두 정점의 루트를 비교해,
   - 이미 같은 집합이라면 간선을 추가하는 순간 **사이클이 생기므로 false**를 반환하고,
   - 다르다면 더 큰 집합 쪽에 작은 집합을 붙이며(true 반환) 집합 크기를 갱신합니다.

```java
static boolean union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) return false; // cycle
    if (size[a] < size[b]) {
        int t = a;
        a = b;
        b = t;
    }
    parent[b] = a;
    size[a] += size[b];
    return true;
}
```

4. 각 턴 `i`마다 들어오는 간선 `(a, b)`에 대해 `union(a, b)`를 수행해
   - `false`가 처음 반환되는 턴 번호 `i + 1`을 정답으로 저장하고 반복을 종료합니다.
   - 끝까지 사이클이 생기지 않으면 0을 출력합니다.

```java
int ans = 0;
for (int i = 0; i < m; i++) {
    // 입력...
    if (!union(a, b)) {
        ans = i + 1;
        break;
    }
}
System.out.println(ans);
```

## :black_nib: **Review**

- (소감을 작성해주세요.)

## 📡 Link

https://www.acmicpc.net/problem/20040
