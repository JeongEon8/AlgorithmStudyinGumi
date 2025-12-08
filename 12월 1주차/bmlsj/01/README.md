# [프로그래머스 - lv2] 조이스틱

## ⏰  **time**

40분

## ⏲️**Time Complexity**

$O(N)$

## 풀이

1. 상하 이동

- `A`에서 해당 문자까지의 거리와
- `Z`에서 역방향으로 돌아오는 거리 중 더 작은 값을 더해준다.

=> `N` => `min(N-A, Z-N+1)`

1. 좌우 이동

- `i`까지 오른쪽으로 가고
- `A`가 연속되는 구간을 건너뛰기 위해 뒤로 돌아가는 경우를 계산하여 최소값 구함
    즉, `문자 변경 횟수 + 최소 커서 이동 횟수`

```java
// 1. 상하 이동 (A-Z 조작)
for(char ch : charList) {
    if (ch - 'A' < Math.abs(ch - 'Z')) {
        answer += ch - 'A';
    } else {
        answer += Math.abs(ch - 'Z') + 1;
    }
}

// 2. 좌우 이동 최소화
int length = name.length();
int move = length - 1;

for (int i = 0; i < length; i++) {
    int next = i + 1;

    while (next < length && name.charAt(next) == 'A')
        next++;

    move = Math.min(move, i + length - next + Math.min(i, length - next));
}
```

## :black_nib: **Review**

## 📡**Link**

- <https://school.programmers.co.kr/learn/courses/30/lessons/42860>
