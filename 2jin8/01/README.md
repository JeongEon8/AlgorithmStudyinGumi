# [백준- G4] 7662. 이중 우선순위 큐
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
자료구조 (TreeMap)

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
- TreeMap에 k와 k의 개수를 기록함
- 데이터 삽입 연산
  - 이미 map에 k가 있다면 k의 개수를 1 증가하고 그렇지 않다면 1 넣기
    - `map.put(k, map.getOrDefault(k, 0) + 1)`
- 데이터 삭제 연산
  - 최솟값과 최댓값을 찾아서 k의 개수를 하나 줄이기
    - `firstKey`: 최솟값 찾음
    - `lastKey`: 최댓값 찾음
  - 만약 k의 개수가 0이라면 map에서 삭제하기
```java
for (int i = 0; i < n; i++) {
  st = new StringTokenizer(br.readLine());
  String cmd = st.nextToken();
  int k = Integer.parseInt(st.nextToken());
  
  if (cmd.equals("I")) { // 데이터 삽입 연산
    map.put(k, map.getOrDefault(k, 0) + 1);
  } else if (cmd.equals("D")) { // 데이터 삭제 연산
    // k가 1이면 최댓값 삭제, -1이면 최솟값 삭제
    if (map.size() == 0)
      continue;

    int num = (k == -1 ? map.firstKey() : map.lastKey());

    // map에서 remove 개수 하나 감소
    // 하나만 남았었더라면(현재 0이 되면) map에서 제거하기
    if (map.put(num, map.get(num) - 1) == 1)
      map.remove(num);
  }
}
```

## :black_nib: **Review**
처음에 HashSet과 두 개의 우선순위 큐를 사용했는데 더욱 간단하게 풀 수 있는 방법이 있다는 것을 알았다. TreeMap 사용 방법을 잘 익혀둬야겠다.

## 📡**Link**
- https://www.acmicpc.net/problem/7662
