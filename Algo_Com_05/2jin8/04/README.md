# [SWEA - D4] 14163. 그룹 나누기
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
유니온 파인드

## :round_pushpin: **Logic**
- 유니온 파인드 관련 메서드(`make()`, `findSet()`, `union()` 작성하기
- `union()` 결과가 true면 그룹이 한 사람이 그룹에 포함된 것이므로 그룹의 수를 1씩 감소시키면 됨
```java
static void make() {
  parents = new int[N + 1];
  for (int i = 1; i <= N; i++) {
    parents[i] = i;
  }
}

static int findSet(int a) {
  if (a == parents[a])
    return a;

  return parents[a] = findSet(parents[a]);
}

static boolean union(int a, int b) {
  int aRoot = findSet(a);
  int bRoot = findSet(b);
  if (aRoot == bRoot)
    return false;

  parents[bRoot] = aRoot;
  return true;
}
```

## :black_nib: **Review**
예제 이해를 못해서 헤매다가 단순히 유니온 파인드를 사용하면 된다는 것을 알게 되었다. 

## 📡**Link**
- https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AX--pdmaF9YDFARi
