# [백준 - 실버 4] 3986. 좋은 단어

## ⏰**time**
10분

## :pushpin: **Algorithm**
* 스택 (Stack)
* 문자열 처리

## ⏲️**Time Complexity**
$O(N \cdot L)$

## :round_pushpin: **Logic**
1. 각 단어에 대해 **스택**을 이용해 인접한 같은 문자를 처리
2. 문자를 순서대로 읽으며

   * 스택이 비어 있으면 push
   * 스택 top과 현재 문자가 같으면 pop (짝이 맞음)
   * 다르면 push
3. 마지막에 스택이 **비어있다면** 좋은 단어로 판단
4. 반복하며 좋은 단어의 개수 카운트

```
for word in words:
    stack = []
    for ch in word:
        if stack is not empty and stack.top == ch:
            stack.pop()
        else:
            stack.push(ch)
    if stack is empty:
        count++
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/3986](https://www.acmicpc.net/problem/3986)
