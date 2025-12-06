
# [백준 - S1] 1713. 후보 추천하기

## ⏰  **time**
60분에서 120분 사이

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 아직 map 이 사진틀의 수에 도달하지 않았으면, 후보자를 사진틀에 넣는다.
2. 만약 이미 사진틀에 있으면 추천수 1증가 시킨다.
3. 만약 map의 크기가 사진틀을 넘게 되면, 추천수가 가장 작고 같으면 게시된 지 가장 오래된 사진을 삭제한다.
    - 즉 `cnt`가 가장 작고, 같으면 `idx`가 가장 작은 것을 제거한다.

```java
HashMap<Integer, Node> map = new HashMap<>();

  for (int i = 0; i < m; i++) {
   int candidate = nums[i];

   if (map.containsKey(nums[i])) {
    // 이미 있으면
    map.get(candidate).cnt++; // 추천 수 증가
   } else {
    if (map.size() < n) { // 추천수 여유 있을 때
     map.put(candidate, new Node(candidate, i, 1));
    } else {
     // 꽉 찾으면 제거 => cnt가 가장 작고 같으면 idx가 가장 작은 것 제거
     int removeNum = -1;
     int minCnt = Integer.MAX_VALUE;
     int minIdx = Integer.MAX_VALUE;

     for (Node node : map.values()) {
      if (node.cnt < minCnt || (node.cnt == minCnt && node.idx < minIdx)) {
       minCnt = node.cnt;
       minIdx = node.idx;
       removeNum = node.num;
      }
     }

     map.remove(removeNum);
     map.put(candidate, new Node(candidate, i, 1));

    }
   }
  }
```

## :black_nib: **Review**
실력이 먼가 퇴화하는 거 같기도..?

## 📡**Link**

- <https://www.acmicpc.net/problem/1713>
