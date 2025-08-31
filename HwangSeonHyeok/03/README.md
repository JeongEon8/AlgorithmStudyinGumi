# [백준 - S4] 2034. 반음 

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 브루트포스 알고리즘
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
알파벳 순으로 답을 구해야하므로 A를 0으로 하고 A~G까지 시작 음계로 시작하여 계산하고 중간 과정이 모두 A~G에 포함되는지 확인한다.
```java
Map<Integer, Character> iToNotes = new HashMap<>();
iToNotes.put(0, 'A');
iToNotes.put(2, 'B');
iToNotes.put(3, 'C');
iToNotes.put(5, 'D');
iToNotes.put(7, 'E');
iToNotes.put(8, 'F');
iToNotes.put(10, 'G');
for (int i = 0; i < 7; i++) {
    int start = arr[i];
    int current = start;
    boolean isAble = true;
    for (int input : inputs) {
        current = Math.floorMod(current + input, 12);
        if (!iToNotes.containsKey(current)) {
            isAble = false;
            break;
        }
    }
    if (isAble) {
        sb.append(iToNotes.get(start)).append(" ").append(iToNotes.get(current)).append("\n");

    }

}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2034