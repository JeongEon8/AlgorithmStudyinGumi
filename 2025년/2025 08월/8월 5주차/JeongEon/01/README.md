# \[백준 - 실버 3] 1021. 회전하는 큐

## ⏰  **time**

10분

## \:pushpin: **Algorithm**

덱(Deque) 시뮬레이션 + 그리디 회전

## ⏲️**Time Complexity**

\$O(N \times M)\$

* 매 타겟마다 위치 탐색 $O(N)$ + 회전/제거 $O(\text{회전 횟수})$
* 전체적으로 상수 연산이 작아 충분히 빠름

## \:round\_pushpin: **Logic**

1. 1부터 $N$까지 덱에 채운다.
2. 뽑을 값 $x$의 현재 인덱스 `idx`를 선형 탐색으로 찾는다.
3. `idx <= dq.size()/2`면 **왼쪽 회전**(front를 back으로), 아니면 **오른쪽 회전**(back을 front로).
4. `dq.front() == x`가 되면 `pop_front()`로 제거하고 다음 값으로 진행.
5. 회전할 때마다 `res++`로 누적하여 최종 출력.

```cpp
// 타겟 위치 찾기
for (int i = 0; i < dq.size(); i++) if (dq[i] == x) { idx = i; break; }

// 더 가까운 쪽으로 회전
if (idx <= dq.size() / 2) {              // 왼쪽 회전
  while (dq.front() != x) { ++res; dq.push_back(dq.front()); dq.pop_front(); }
  dq.pop_front();
} else {                                  // 오른쪽 회전
  while (dq.front() != x) { ++res; dq.push_front(dq.back()); dq.pop_back(); }
  dq.pop_front();
}
```

## \:black\_nib: **Review**

* 매 단계에 “왼쪽/오른쪽 중 더 가까운 쪽”만 선택하면 자연스럽게 최소 회전 횟수!
* `idx` 선형 탐색이라도 입력 범위에서 충분히 통과한다는 점이 깔끔.

## 📡 Link

[https://www.acmicpc.net/problem/1021](https://www.acmicpc.net/problem/1021)
