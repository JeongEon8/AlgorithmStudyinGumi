# [백준- G3] 9466. 텀 프로젝트
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- `notTeam`: 팀에 속하지 않은 학생의 수, N으로 초기화함
- 이미 팀 확인 완료한 학생인 경우 > 탐색 종료
- 팀 확인 완료하지 않았는데 이미 방문한 경우 > 사이클 발생
  - 팀에 속한 것이므로 `notTeam` 값 1개 감소시키기
```java
static void checkTeam(int student) {
    // 이미 팀 확인 완료한 학생인 경우
    if (done[student]) return;

    // 팀 확인 완료하지 않았는데 이미 방문한 경우
    if (visited[student]) { // 사이클 발생 == 팀에 속함
        notTeam--;
        done[student] = true;
    }

    visited[student] = true;
    checkTeam(arr[student]);
    visited[student] = false;

    done[student] = true;
}
```

## :black_nib: **Review**
전에 풀었던 문제와 유사하다! DFS 탐색으로 사이클을 탐지하는 것만 잘 기억하면 될 듯

## 📡**Link**
- https://www.acmicpc.net/problem/9466
