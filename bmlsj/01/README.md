# [백준 - S4] 나는야 포켓몬 마스터 이다솜

## ⏰  **time**

30분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 이름으로 접근할 수 있는 map과 위치로 접근 가능한 map2를 생성한다.
2. 출력할 `M`만큼의 `query`에서 숫자면 map2에서 값을 가져오고, 문자면 map에서 값을 가져온다.

```java
HashMap<String, Integer> map = new HashMap<String, Integer>();
HashMap<Integer, String> map2 = new HashMap<Integer, String>();
for (int t = 0; t < N; t++) {
   String input = br.readLine();
   map.put(input, t + 1);
   map2.put(t + 1, input);
}

for (int i = 0; i < M; i++) {
   String query = br.readLine();
   if (Character.isDigit(query.charAt(0))) {
        int num = Integer.parseInt(query);
        System.out.println(map2.get(num));
   } else {
        System.out.println(map.get(query));
   }
}
```

## :black_nib: Review

## 📡**Link**

- <https://www.acmicpc.net/problem/1620>
