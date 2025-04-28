# [백준 - S5] 3135. 라디오

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
```java
int ans = Math.abs(B-A);
int n = Integer.parseInt(in.readLine());
for(int i = 0; i<n;i++){
    int bookmark = Integer.parseInt(in.readLine());
    ans = Math.min(ans,Math.abs(B-bookmark)+1);
}
```  
각 북마크까지 이동하는데는 1번필요하므로 (시작~목표까지의 차), (북마크~목표까지의차+1)중에 가장 작은 값을 찾으면된다.
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/3135
