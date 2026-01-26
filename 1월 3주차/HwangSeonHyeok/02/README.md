# [백준 - S3] 30504. 세과영엔 슬픈 전설이 있어

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
세종이의 분노수치와 해당 일수를 담은 Fury클래스를 만든다.  
자루와 분노치를 오름차순으로 정렬하고 작은것부터 1대 1로 매칭할 수 없으면 분노를 피할 수 없는 상황아디.
해당 일수와 자루의 무게를 매칭시켜서 순서대로 출력한다.
```java
Arrays.sort(furies);
Arrays.sort(pockets);
int[] ans = new int[n];
for (int i = 0; i < n; i++) {
    if (furies[i].point > pockets[i]) {
        System.out.println(-1);
        return;
    }
    ans[furies[i].idx] = pockets[i];
}
```
## :black_nib: **Review**
코드 자체를 간만에 작성하려니 만족스럽지 않게 나왔다.  
재활이 필요해..

## 📡**Link**
https://www.acmicpc.net/problem/30504