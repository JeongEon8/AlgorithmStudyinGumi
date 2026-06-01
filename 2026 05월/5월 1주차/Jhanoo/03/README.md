# [프로그래머스 - Lv2] 다음 큰 숫자

## ⏰**time**

30분

## :pushpin: **Algorithm**

- 비트 연산
- 구현 (같은 1 비트 개수를 유지한 최소 증분)

## ⏲️**Time Complexity**

$O(\log n)$  
(`n` 이하의 비트만 순회)

## :round_pushpin: **Logic**

1. LSB에서 비트를 올려가며 `1`이 처음 나오는 위치를 `minNum`에 기록한다. (`k`는 `1, 2, 4, ...`)

2. `1` 비트를 만날 때마다 `cnt`를 1 증가시킨다. 처음 만난 `1`의 위치는 `minNum`에 저장하고 `findMinBit`를 켠다.

3. `findMinBit`가 켜진 상태에서 `0` 비트를 만나면 루프를 끝낸다.  
   이때 구간은 “맨 아래쪽 연속 `1` 묶음 + 바로 위의 `0`” 경계에 해당한다.

```java
while (true) {
    if (findMinBit && (n & k) == 0) break;
    if ((n & k) != 0) {
        if (!findMinBit) {
            findMinBit = true;
            minNum = k;
        }
        cnt++;
    }
    k <<= 1;
}
```

4. `n + minNum`으로 위 묶음 중 가장 아래 `1`을 한 칸 위 `0`과 맞바꾸는 효과를 낸 뒤,  
   `cnt--`로 다시 오른쪽에 붙여야 할 `1`의 개수를 맞춘다.

```java
int answer = n + minNum;
cnt--;
```

5. `answer`의 남은 빈 칸부터 최하위 쪽으로 `cnt`번 `1`을 채워 넣는다. 같은 개수의 `1`을 유지하면서 `n`보다 크면서 최소인 수가 된다.

```java
k = 1;
while (cnt > 0) {
    if ((answer & k) == 0) {
        cnt--;
        answer += k;
    }
    k <<= 1;
}
```

6. `answer`를 반환한다.

## :black_nib: **Review**

- 난 비트 재배치했는데, 브루트포스로 2줄로 풀 수 있다고? 충격...

```java
    int count = Integer.bitCount(n);
    while (Integer.bitCount(++n) != count);
```

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12911
