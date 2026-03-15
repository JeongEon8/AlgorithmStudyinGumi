# [백준 - 실버 5] 7785. 회사에 있는 사람

## ⏰**time**

약 20분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. treemap을 사용해서 기본적으로 Key값으로 정렬이 가능하게 한다.
1. enter이면 0, leave면 1로 상태를 변경한다.
1. 상태가 1인 사람만 출력

```java
TreeMap<String, Integer> worker = new TreeMap<>(Comparator.reverseOrder());
for (int i = 0; i < N; i++) {
    String[] split = br.readLine().split(" ");
    String name = split[0];
    String status = split[1];

    if (status.equals("enter")) {
        worker.put(name, 0);
    } else {
        worker.put(name, 1);
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://www.acmicpc.net/problem/7785>
