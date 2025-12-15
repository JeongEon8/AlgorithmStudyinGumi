# [백준 - S5] 10815. 숫자 카드

## ⏰  **time**

20분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

상근이가 가진 숫자 카드를 HashMap에 삽입
카드가 HashMap에 이미 있다면 1, 없다면 0을 출력

```java
HashMap<Integer, Integer> cards = new HashMap<>();
String[] split = br.readLine().split(" ");
for (int i = 0; i < N; i++) {
   int num = Integer.parseInt(split[i]);
   cards.put(num, 0);
}

int M = Integer.parseInt(br.readLine());
int[] nums = new int[M];

split = br.readLine().split(" ");
for (int i = 0; i < M; i++) {
   nums[i] = Integer.parseInt(split[i]);
   if (cards.containsKey(nums[i])) {
    System.out.print(1 + " ");
   } else {
    System.out.print(0 + " ");
   }
}
```

## :black_nib: Review

## 📡**Link**

- <https://www.acmicpc.net/problem/10815>
