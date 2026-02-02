# [백준 - S3] 13414. 수강신청

## ⏰  **time**

30분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 뒤에서 입력받는 순으로 map에 넣고, 이미 map에 있다면 넣지 않는다.
2. value 를 기준으로 정렬한 후, 수강 가능한 인원 `K`(여기서 `N`)만큼만 출력한다.

```java
int idx = 0;
for (int i = M - 1; i >= 0; i--) {
 if (map.containsKey(students[i]))
  continue;
 map.put(students[i], idx++);
}
  
List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
list.sort((e1, e2) -> e2.getValue() - e1.getValue());
  
idx = 0;
for (Map.Entry<String, Integer> entry : list) {
 if (idx == N) break;
    System.out.println(entry.getKey());
    idx++;
}
```

## :black_nib: Review

map을 정렬하기 뒤해 `Entry`를 사용

## 📡**Link**

- <https://www.acmicpc.net/problem/13414>
