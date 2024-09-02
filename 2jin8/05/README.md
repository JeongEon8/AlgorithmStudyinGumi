# [백준 - G4] 1647. 도시 분할 계획
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
최소 신장 트리

## :round_pushpin: **Logic**
- 그룹이 2개가 될 때까지 크루스칼 알고리즘 수행하기
- 이때, 처음부터 그룹이 2개로 분리되었다면 0을 출력하고 종료하기
```java
int weight = 0, group = N;
if (group == 2) { // 이미 두 개의 마을로 분할된 경우
  System.out.println(0);
  return;
}

for (Edge edge : edges) {
  // 대표자가 다르다면 그룹의 수 1개 감소 & 가중치 더하기
  if (union(edge.a, edge.b)) {
    weight += edge.w;
    // 마을을 두 개로 분리하면 종료하기
    if (--group == 2)
      break;
  }
}
```

## :black_nib: **Review**
크루스칼 알고리즘을 까먹은 것 같아서 관련 문제를 풀어봤다. 잊은 것 같았는데 그래도 문제를 풀려고 하니 기억이 났다. 
그리고 처음부터 그룹이 2개일 수도 있다는 조건을 생각하지 못해서 97%에서 틀렸었다ㅎ.. 조건을 잘 생각해야지..

## 📡**Link**
- https://www.acmicpc.net/problem/1647
