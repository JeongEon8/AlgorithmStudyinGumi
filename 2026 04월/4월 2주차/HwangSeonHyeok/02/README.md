# [백준 - S5] 3711. 학번

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
브루트 포스로 모든 학생들의 학번을 1부터 나머지연산해본다.  
매번 boolean 배열을 초기화하면 메모리초과가되므로 실행횟수를 int 배열에 기록하면서 중복여부를 찾는다.
```java
for (int i = 1; i < 1000000; i++) {
    tryCnt++;
    boolean isAble = true;
    for (int student : students) {
        int mod = student % i;
        if (used[mod] == tryCnt) {
            isAble = false;
            break;
        }
        used[mod] = tryCnt;
    }
    if (isAble) {
        System.out.println(i);
        break;
    }
}
```
## :black_nib: **Review**

## 📡**Link**
https://www.acmicpc.net/problem/3711