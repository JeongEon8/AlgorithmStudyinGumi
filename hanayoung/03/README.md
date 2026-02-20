# [백준 - S5] 7785. 회사에 있는 사람

## ⏰  **time**
20분

## :pushpin: **Algorithm**
해시와 맵

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. enter라는 해시맵 생성하여 현재 회사에 있는 사람 관리
2. 이름 뒤에 들어온 값이 "enter"라면, enter에 name을 key로 true 값 삽입
3. "enter"가 아니라면 이름을 key로 가지는 값 삭제
```java
        Map<String, Boolean> enter = new HashMap<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            if("enter".equals(st.nextToken())) {
                enter.put(name, true);
            } else {
                enter.remove(name);
            }
        }
```
4. 역순으로 정렬하는 pq 생성하여 keySet을 순회하며 삽입
```java
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(String name: enter.keySet()) {
            pq.add(name);
        }
```
5. 우선순위큐에서 하나씩 꺼내서 sb에 붙이기
```java
        while(pq.size() > 0) {
            sb.append(pq.poll()).append("\n");
        }
```

6. sb 출력하기


## :black_nib: **Review**
- 우선순위큐 최고!

## 📡 Link
https://www.acmicpc.net/problem/7785
