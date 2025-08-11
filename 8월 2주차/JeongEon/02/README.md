# \[백준 - 실버 2] 1927. 최소 힙

## ⏰  **time**

10분

## \:pushpin: **Algorithm**

우선순위 큐 (최소 힙)

## ⏲️**Time Complexity**

\$O(N \log N)\$

* `push` 연산: \$O(\log N)\$
* `pop` 연산: \$O(\log N)\$
* 총 \$N\$번 연산 시 \$O(N \log N)\$

## \:round\_pushpin: **Logic**

1. 최소 힙을 구현하기 위해 `priority_queue<int, vector<int>, greater<>>` 사용.
2. 입력값이 **0**일 경우:

   * 힙이 비어 있으면 `0` 출력.
   * 비어 있지 않으면 최솟값(`pq.top()`) 출력 후 `pop()`.
3. 입력값이 **0이 아닌 경우**:

   * 해당 값을 힙에 `push()`.
4. 모든 연산을 입력 순서대로 처리.

```cpp
priority_queue<int, vector<int>, greater<>> pq;

if (input == 0) {
    if (pq.empty()) cout << 0 << '\n';
    else {
        cout << pq.top() << '\n';
        pq.pop();
    }
} else {
    pq.push(input);
}
```

## \:black\_nib: **Review**

* `greater<>`를 사용하면 최소 힙을 간단하게 구현할 수 있어서 편리했다.
* 직접 heapify 로직을 구현하지 않아도 돼서 시간 단축에 효과적이었음.

## 📡 Link

[https://www.acmicpc.net/problem/1927](https://www.acmicpc.net/problem/1927)
