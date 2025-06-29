# [백준 - S2] 10819. 차이를 최대로

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 브루트포스 알고리즘
- 백트래킹
## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
n이 최대 8로 작으므로 순열을 만들면서 합을 구해서 최대값을 만들면 된다.
```java
static void solve(int idx, int num, int sum) {
    if (num == n) {
        ans = Math.max(ans, sum);
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!selected[i]) {
            selected[i] = true;
            solve(i, num + 1, sum + Math.abs(arr[idx] - arr[i]));
            selected[i] = false;
        }
    }

}



for (int i = 0; i < n; i++) {
    selected[i] = true;
    solve(i, 1, 0);
    selected[i] = false;
}
```

## :black_nib: **Review**
뭔가 깔끔하지 않은 풀이  
n이 커질때 복잡도를 줄일 방법을 더 고민해봐야겠다.
## 📡**Link**

https://www.acmicpc.net/problem/10819
