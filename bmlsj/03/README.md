# [백준 - S2] 1138. 한 줄로 서기

## ⏰ **time**

60분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 왼쪽에 큰 사람이 많은 순으로 정렬한다.
2. 스택 st에 있는 수 중 나보다(`idx`) 큰 수의 개수를 센다.
3. 큰 수의 개수가 주어진 왼쪽에 나보다 큰 사람의 수(`tallerFrontOfMe`)와 같으면,
   스택 st에 추가한다.
4. 만약 더 크다면 같아질때까지 임시 `tmp`에 넣어둔 뒤,
   현재 위치인 `idx`를 추가한 후 임시 `tmp`의 값들을 추가한다.

```java
Stack<Integer> st = new Stack<>();
for (int idx : map.keySet()) {

    Stack<Integer> tmp = new Stack<>();
    int tallerFrontOfMe = map.get(idx); // 앞쪽에 나보다 큰 사람 수
    int cnt = 0;

    for (int num : st) {
        if (num > idx) { // 나보다 큰 수
        cnt++;
        }
    }

    if (cnt == tallerFrontOfMe) {
        st.add(idx);
    } else {
        while (cnt > tallerFrontOfMe) {
            cnt--;
            tmp.add(st.pop());
        }

        st.add(idx);
        while (!tmp.isEmpty()) {
            st.add(tmp.pop());
        }
    }
}
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/1138](https://www.acmicpc.net/problem/1138)
