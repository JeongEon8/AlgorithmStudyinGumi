# [백준 - 실버 2] 15903. 카드 합체 놀이

## ⏰**time**

60분

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(nlogn )$

## :round_pushpin: **Logic**

1. 카드 값을 우선순위 큐(PriorityQueue) 에 넣는다.
2. m번 반복하면서 가장 작은 카드 두 개를 꺼내 합을 구한 뒤, 그 값을 두 번 다시 큐에 넣는다.
3. 모든 연산이 끝나면 큐에 남아있는 카드 값들을 모두 더해 결과를 출력한다.

```java
for (int t = 0; t < m; t++) {

 if (cards.size() >= 2) {
  Long a = cards.poll();
  Long b = cards.poll();

  cards.add(a + b);
  cards.add(a + b);
 }
}

long ans = 0;
for(long card: cards) {
 ans += card;
}
System.out.println(ans);
```

## :black_nib: **Review**

## 📡 Link

<https://www.acmicpc.net/problem/15903>
