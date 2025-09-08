# \[백준 - 실버 1] 21608. 상어 초등학교

## ⏰  **time**

30분

## \:pushpin: **Algorithm**

시뮬레이션 + 우선순위 큐

## ⏲️**Time Complexity**

\$O(N^4)\$

* 학생 수 $N^2$ × 자리 후보 탐색 $N^2$ × 인접 4칸 확인(상수)

## \:round\_pushpin: **Logic**

1. 입력: 학생 `id`와 좋아하는 친구 4명을 저장. 좌석판은 `0`(빈칸)/학생번호로 관리.
2. 각 학생을 한 명씩 배치할 때, 모든 빈 칸을 후보로 보며 아래 우선순위로 **최적 좌석**을 고른다.

   * (1) 인접 4칸에 있는 **좋아하는 친구 수**가 많은 자리
   * (2) (1)이 같다면 **빈 칸 수**가 많은 자리
   * (3) (1)(2)가 같다면 **행 번호가 작은** 자리
   * (4) (1)(2)(3)이 같다면 **열 번호가 작은** 자리
3. 우선순위는 `priority_queue`의 비교 연산자로 처리.

```cpp
struct info {
  int x, y, blankCnt = 0, friendCnt = 0;
  bool operator<(const info& o) const {
    if (friendCnt != o.friendCnt) return friendCnt < o.friendCnt; // 더 많은 친구 우선
    if (blankCnt  != o.blankCnt ) return blankCnt  < o.blankCnt;  // 더 많은 빈칸 우선
    if (x != o.x)                return x > o.x;                  // 행 번호 오름차순
    return y > o.y;                                              // 열 번호 오름차순
  }
};
```

4. 배치가 끝나면 모든 학생에 대해 **인접 4칸의 좋아하는 친구 수**를 세고 만족도 배열 `manjok = {0,1,10,100,1000}`으로 누적합을 계산.

```cpp
// 각 빈 칸마다 인접 친구/빈칸 카운트 후 PQ에 푸시
for (int i = 0; i < N; i++)
  for (int j = 0; j < N; j++)
    if (board[i][j] == 0) {
      int blank=0, fr=0;
      for (int d=0; d<4; d++){
        int nx=i+dx[d], ny=j+dy[d];
        if (nx<0||nx>=N||ny<0||ny>=N) continue;
        if (board[nx][ny]==0) blank++;
        else if (isFav(board[nx][ny], students[s])) fr++; // 4명 목록 중 포함 여부
      }
      pq.push({i,j,blank,fr});
    }
// 최적 자리 = pq.top()
```

## \:black\_nib: **Review**

* 조건 4개(친구 수 → 빈 칸 수 → 행 → 열)만 정확히 우선순위에 반영하면 구현은 깔끔.
* 만족도 계산 시 인접 4칸만 보면 되니 `manjok[friends]`로 바로 매핑하니 편했다.
* 시간복잡도는 $N \le 20$라서 전체 $N^4$ 시뮬레이션도 충분히 통과!

## 📡 Link

[https://www.acmicpc.net/problem/21608](https://www.acmicpc.net/problem/21608)
