# [백준 - S5] 30457. 단체줄넘기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 구현
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
각 학생들은 같은 키의 학생이 3명 이상이 되면 반드시 걸리는 사람이 생긴다. 같은 키의 학생이 두명까진 각각 다른 방향을 보면 걸리지 않고 뛸 수 있으므로 
```java
heights = new int[1001];
for (int i = 0; i < n; i++) {
    int h = Integer.parseInt(st.nextToken());
    heights[h]++;
}
int ans = 0;
for (int h : heights) {
    if (h == 1) {
        ans++;
    } else if (h >= 2) {
        ans += 2;
    }
}
```

## :black_nib: **Review**
지금 보니까 Math.min(h,2)로 했으면 if문 없이 해결가능했을듯..
## 📡**Link**

https://www.acmicpc.net/problem/30457