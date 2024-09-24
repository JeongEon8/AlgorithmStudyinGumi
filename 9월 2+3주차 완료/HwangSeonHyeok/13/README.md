# [백준 - s4] 1205. 등수 구하기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현

## :round_pushpin: **Logic**

몇몇 예외처리를 하고 점수랭킹을 내림차순으로 정렬하고 자신의 점수가 랭커 이상이되는 등수를 찾는다.

```java
if (n == 0) {
    System.out.println(1);
} else {
    List<Integer> ranking = new ArrayList<>();
    split = in.readLine().split(" ");
    for (int i = 0; i < n; i++) {
        ranking.add(Integer.parseInt(split[i]));
    }
    Collections.sort(ranking, Collections.reverseOrder());
    int ans = 1;
    if (n == p && sc <= ranking.get(n - 1)) {
        ans = -1;
    } else {
        for (Integer ranker : ranking) {
            if (ranker <= sc) break;
            ans++;
        }
    }
    System.out.println(ans);
}
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/1205
