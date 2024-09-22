# [백준 - s2] 16112. 5차 전직

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## :round_pushpin: **Logic**

경험치를 조금 주는것부터 오름차순으로 정렬하고 최대 k개까지 동시에 경험치를 쌓을 수 있으므로 지금까지 얻은 아케인스톤의 개수(=index)와 k중 더 작은 값만큼 곱해준 값이 그 퀘스트에서 얻을 수 있는 경험치이다.

```java
Arrays.sort(arcanes);
long ans = 0;
for (int i = 0; i < n; i++) {
    ans += arcanes[i] * Math.min(i, k);
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/16112
