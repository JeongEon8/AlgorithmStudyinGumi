# [백준 - 실버 3] 9375. 패션왕 신해빈

## ⏰**time**

15분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 의상의 종류별 개수를 HashMap으로 저장한다.
2. 각 카테고리마다 `입는 경우 + 안 입는 경우`를 고려하여 `(개수 + 1)`을 곱한다.
3. 아무것도 입지 않는 경우를 제외하기 위해 마지막에 -1을 한다.

```java
for (int t = 0; t < tc; t++) {
    int n = Integer.parseInt(br.readLine()); // 의상 수

    HashMap<String, Integer> clothes = new HashMap<>();
    for (int i = 0; i < n; i++) {
        String[] split = br.readLine().split(" ");

        clothes.put(split[1], clothes.getOrDefault(split[1], 0) + 1);

    }

    int ans = 1;
    for (int cnt : clothes.values()) {
        ans *= (cnt + 1);
    }
    System.out.println(ans - 1);
}
```

## :black_nib: **Review**

백준이 없어지면 머해야하지

## 📡 Link

- <https://www.acmicpc.net/problem/9375>
