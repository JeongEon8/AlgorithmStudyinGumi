# [백준 - S5] 22970. 문제 재탕


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 구현
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
올라가는상태와 내려가는상태, 앞과 같은경우를 나눠서 처리한다.
```java
StringTokenizer st = new StringTokenizer(in.readLine());
for (int i = 0; i < n; i++) {
    int current = Integer.parseInt(st.nextToken());
    if (prev == current) {
        prev = current;
        ans = Math.max(ans, currentCnt);
        isUp = true;
        currentCnt = 1;
        continue;
    }
    if (isUp) {
        currentCnt++;
        if (prev >= current) {
            isUp = false;
        }

    } else {
        if (prev > current) {
            currentCnt++;
        } else {
            ans = Math.max(ans, currentCnt);
            isUp = true;
            if (prev < current) {
                currentCnt = 2;
            } else {
                currentCnt = 1;
            }
        }
    }
    prev = current;
}
ans = Math.max(ans, currentCnt);

```

## :black_nib: **Review** 

## 📡**Link**
https://www.acmicpc.net/problem/22970