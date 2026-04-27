# [백준 - S1] 1141. 접두사

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

처음에 문자가 8이고 L과 R이 같으면 `ans`를 1증가시켰는데, 그러면 숫자가 8이 아닐때 무조건 종료된다.
처음 8을 만나고 공통 접두사가 8인지 확인해야한다.
근데 이렇게 접두사로 푸는게 맞는 걸가

```java
if (L.length != R.length) {
    System.out.println(0);
    return;
}

int ans = 0;
for(int i = 0; i < L.length; i++) {
    if (L[i] == R[i]) {
        if (L[i] == '8') {
            ans++;
        }
    } else {
        break;
    }
}
System.out.println(ans);
```

## :black_nib: Review

흑흑.. 괴로워.. 알고리즘 지옥이다.

## 📡**Link**

- [https://www.acmicpc.net/problem/1105](https://www.acmicpc.net/problem/1105)
