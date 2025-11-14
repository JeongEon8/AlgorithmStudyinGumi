# [백준- S4] 17219. 비밀번호 찾기

## ⏰  **time**
10분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

알고리즘이랄게 없었다!
그냥.. 사이트 주소에 맞게 비밀번호를 저장후 해당 사이트 주소에 저장된 비밀번호 찾기!

```java
HashMap<String, String> map = new HashMap<>();
for (int i = 0; i < n; i++) {
	split = br.readLine().split(" ");
	map.put(split[0], split[1]);
}

for (int i = 0; i < m; i++) {
	String input = br.readLine();
	System.out.println(map.get(input));
}
```

## :black_nib: **Review**

많이 쉬울지도..?

## 📡**Link**
- https://www.acmicpc.net/problem/17219
