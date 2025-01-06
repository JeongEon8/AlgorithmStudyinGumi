# [백준 - S3️] 18115. 카드 놓기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 자료구조
- 덱

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

카드를 놓는 방법에 따라 1, 2, 3 세가지로 나눠서 내려놓는 순서의 역으로 쌓아 올리면 되는 문제.

```cpp
		for (int i = 1; i <= n; i++) {

        int temp;

        switch (vec[n - i]) {

        case 1:
            dq.push_front(i);
            break;

        case 2:
            temp = dq.front();
            dq.pop_front();
            dq.push_front(i);
            dq.push_front(temp);
            break;

        case 3:
            dq.push_back(i);
            break;
        }

    }
```

## :black_nib: **Review**

- 카드를 위, 아래 양쪽방향으로 모두 쌓아 올릴 수 있으므로 다른 자료구조를 사용 할 수도 있지만 deque를 활용하는게 가장 편한문제다

## 📡**Link**

- https://www.acmicpc.net/problem/18115
