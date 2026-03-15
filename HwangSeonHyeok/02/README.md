# [백준 - S5] 31908. 커플링 매치

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 자료 구조
- 집합과 맵
- 해시를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
문구를 키로, 그 문구의 반지를 가진사람의 이름 리스트를 밸류로한 맵을 만든다.  
리스트의 길이가 2인 경우를 찾는다.
```java
Map<String, List<String>> map = new HashMap<>();
for (int i = 0; i < n; i++) {
    StringTokenizer st = new StringTokenizer(in.readLine());
    String name = st.nextToken();
    String sentence = st.nextToken();
    if ("-".equals(sentence)) {
        continue;
    }
    if (!map.containsKey(sentence)) {
        map.put(sentence, new ArrayList<String>());
    }
    map.get(sentence).add(name);
}
int cnt = 0;
StringBuilder sb = new StringBuilder();
for (List<String> list : map.values()) {
    if (list.size() == 2) {
        cnt++;
        sb.append(list.get(0)).append(" ").append(list.get(1)).append('\n');
    }
}
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/31908