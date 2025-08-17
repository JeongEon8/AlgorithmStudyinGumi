# [백준 - S3] 30046. HJS

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 브루트포스 알고리즘
- 많은 조건 분기

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
높은 자릿수의 수가 더 크면 더 큰 수이므로 두 string에서 처음으로 서로 다른 알파벳 중 더 큰 수의 알파벳에 더 높은 수를 배정하면된다.  
p와 q, q와 r 두번의 비교로 배정을 하는데 이때 모순이 나올 수 있는 경우를 체크한다.
```java
for (int i = 0; i < n; i++) {
    if (p.charAt(i) != q.charAt(i)) {
        idx1 = i;
        break;
    }
}
if (idx1 == -1)
    isAble = false;
if (isAble) {
    for (int i = 0; i < n; i++) {
        if (q.charAt(i) != r.charAt(i)) {
            idx2 = i;
            break;
        }
    }
    if (idx2 == -1) {
        isAble = false;
    } else if (p.charAt(idx1) == r.charAt(idx2) && q.charAt(idx1) == q.charAt(idx2)) {
        isAble = false;	
    }
}
```

## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/30046