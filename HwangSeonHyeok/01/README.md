# [백준 - g2] 1766. 문제집

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 자료 구조
- 그래프 이론
- 우선순위 큐
- 위상 정렬
- 방향 비순환 그래프

## :round_pushpin: **Logic**

문제의 선행 순서를 지키되 쉬운 문제(제 코드에선 num이 작은 문제)부터 풀게하면 되는 문제다. 위상정렬을 할 때 우선순위 큐를 사용하고 정렬 기준을 난이도(num) 오름차순으로 정렬되게 사용하면 된다.

```java
    static class Problem implements Comparable<Problem> {
        int num;
        List<Integer> next;

        public Problem(int num) {
            this.num = num;
            next = new ArrayList<Integer>();
        }

        @Override
        public int compareTo(Problem o) {
            return this.num - o.num;
        }
    }

    int[] back = new int[n + 1];
    List<Problem> pList = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        pList.add(new Problem(i));
    }
    for (int i = 0; i < m; i++) {
        split = in.readLine().split(" ");
        int from = Integer.parseInt(split[0]);
        int to = Integer.parseInt(split[1]);
        back[to]++;
        pList.get(from).next.add(to);
    }
    PriorityQueue<Problem> pq = new PriorityQueue<>();
    for (int i = 1; i <= n; i++) {
        if (back[i] == 0) {
            pq.add(pList.get(i));
        }
    }
    while (!pq.isEmpty()) {
        Problem p = pq.poll();
        sb.append(p.num + " ");
        for (int next : p.next) {
            if (--back[next] == 0) {
                pq.add(pList.get(next));
            }
        }
    }
```

## :black_nib: **Review**

위상정렬에 약간의 조건을 추가한 문제였다.

## 📡**Link**

https://www.acmicpc.net/problem/1766
