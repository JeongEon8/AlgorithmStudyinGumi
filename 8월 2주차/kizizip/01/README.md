# [백준] 모든 순열


## ⏰ **time**


## :pushpin: **Algorithm**
브루트포스 알고리즘, 백트래킹

## ⏲️**Time Complexity**
O(n*n!)

## :round_pushpin: **Logic**
1. 1부터 n까지 담아두기
2. 중복 배제 위해 visited 배열 사용
3. dfs으로 순열 생성
4. 길이가 n이면 출력, 아니면 숫자 하나 선택 후 방문 표시 → 재귀 → 방문 해제
```java
static void dfs(int depth) {
    if (depth == n) {
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        sb.append("\n");
        return;
    }

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            visited[i] = true;
            answer[depth] = nums[i];
            dfs(depth + 1);
            visited[i] = false; // 백트래킹
        }
    }
}
```

## :black_nib: **Review**
그려 

## 📡**Link**
https://www.acmicpc.net/problem/10974 
