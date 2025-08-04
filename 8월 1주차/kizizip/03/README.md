# [백준] 15654. N과 M (5)


## ⏰ **time**
15분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
O(nPm)

## :round_pushpin: **Logic**
1. n개의 수를 입력받아 정렬, 길이 m짜리 수열을 만들 준비..
2. 중복 배제하려고 visited
3. 백트래킹으로 수열을 만들되, m개를 다 고르면 출력
4. 숫자를 하나 선택하고 방문 표시 후 재귀, 재귀 끝나면 방문 표시 해제
```java
    static void backtrack(int depth) {
    if (depth == m) {
        for (int i = 0; i < m; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
        return;
    }

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            visited[i] = true;
            output[depth] = input[i];
            backtrack(depth + 1);
            visited[i] = false;  // 백트래킹을 위한 방문처리
        }
    }
}
```


## :black_nib: **Review**
백트래킹.. 쉽지만 귀찮

## 📡**Link**
https://www.acmicpc.net/problem/15654
