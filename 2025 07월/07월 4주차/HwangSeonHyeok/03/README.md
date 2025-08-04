# [백준 - S4] 34033. 공금 횡령

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 자료 구조
- 해시를 사용한 집합과 맵
- 집합과 맵
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
각 품목의 횡령 기준금액인 105%금액을 map에다가 저장하고 각 품목이 나올때마다 기준이 보다 높은 경우를 카운팅한다.
```java
HashMap<String, Double> map = new HashMap<>();
for (int i = 0; i < n; i++) {
    st = new StringTokenizer(in.readLine());
    String name = st.nextToken();
    double price = Double.parseDouble(st.nextToken());
    map.put(name, price * 1.05);
}
int ans = 0;
for (int i = 0; i < m; i++) {
    st = new StringTokenizer(in.readLine());
    String name = st.nextToken();
    double price = Double.parseDouble(st.nextToken());
    if (price > map.get(name))
        ans++;
}
```

## :black_nib: **Review**
## 📡**Link**

https://www.acmicpc.net/problem/34033
