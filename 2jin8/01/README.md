# [백준- G5] 2668. 숫자만들기
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 이미 해당 정수를 탐색한 경우 > 종료
- 탐색하지 않았는데 이미 방문한 경우 > 사이클이 발생한 것
  - 정답 리스트에 저장 & 탐색 완료 처리
```java
static void dfs(int idx) {
    // 이미 탐색한 경우
    if (done[idx]) return;

    // 탐색이 완료되지 않았지만 이미 방문한 경우 => 사이클 발생
    if (checked[idx]) {
        // 집합에 넣기 & 탐색 완료 처리
        answer.add(idx);
        done[idx] = true;
    }

    checked[idx] = true;
    dfs(arr[idx]);
    checked[idx] = false;

    done[idx] = true;
}
```

## :black_nib: **Review**
DFS 탐색으로 사이클 탐지 & 포함된 것들 기록하려면 방문 배열 2개 사용해야 한다,,

## 📡**Link**
- https://www.acmicpc.net/problem/2668
