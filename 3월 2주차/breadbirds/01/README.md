# [백준 - 실버 4] 1620. 나는야 포켓몬 마스터 이다솜

## ⏰**time**

30분

## :pushpin: **Algorithm**

hashmap

## :round_pushpin: **Logic**

1. 포켓몬 이름 -> 번호 는 hashmap으로 저장
2. 포켓몬 번호 -> 이름은 배열로 저장
3. 포켓몬 번호가 1부터 시작이니까, i=1; i<=N 이여야함.

- hashmap은 key 로 value 찾는건 잘 되는데, 반대는 안됨. 그래서 번호 -> 이름 검색을 위한 배열이 필요.
- 번호 -> 이름을 검색하는 hashmap 만들어도됨.

```
HashMap<String, Integer> map = new HashMap<>();
```

4. 주요 메서드

```
map.put();
map.get();
```

## 📡 Link

https://www.acmicpc.net/problem/7562
