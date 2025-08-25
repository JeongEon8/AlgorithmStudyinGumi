# \[백준 - 실버 1] 20922. 겹치는 건 싫어

## ⏰  **time**

15분

## \:pushpin: **Algorithm**

투 포인터(슬라이딩 윈도우)

## ⏲️**Time Complexity**

\$O(N)\$

* `st`, `en` 포인터가 각각 배열을 한 번씩만 전진.

## \:round\_pushpin: **Logic**

1. 빈도 배열 `visited[value]`로 현재 윈도우 내 등장 횟수를 관리.
2. `en`을 오른쪽으로 확장하면서 `visited[v[en]] < K`일 때만 포함.
3. 어떤 값의 빈도가 `K`를 넘게 되면 더 이상 확장하지 않고,
   왼쪽 포인터 `st`를 이동하며 `visited[v[st]]--`로 윈도우를 줄인다.
4. 매 스텝에서 `answer = max(answer, en - st)`로 최대 길이를 갱신.
5. `en`이 끝에 도달하면 종료.

```cpp
int en = 0, answer = 0;
for (int st = 0; st < N; st++) {
    while (en < N && visited[v[en]] < K) {
        visited[v[en]]++;
        en++;
    }
    answer = max(answer, en - st);
    if (en == N) break;
    visited[v[st]]--; // 왼쪽을 줄여 다음 반복에서 다시 확장 가능
}
cout << answer << '\n';
```

## \:black\_nib: **Review**

* “각 숫자 최대 K번” 제약을 슬라이딩 윈도우의 **확장/수축 조건**으로 녹이면 바로 풀린다.
* 카운터만 정확히 관리하면 구현이 매우 안정적!

## 📡 Link

[https://www.acmicpc.net/problem/20922](https://www.acmicpc.net/problem/20922)
