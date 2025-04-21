# [백준 - S3] 9375. 패션왕 신해빈

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
1. n개의 의상의 종류와 개수를 hashmap에 저장
2. 해당 종류가 있다면 1을 증가하고, 옷이 없다면 map에 추가
3. 해당 옷에 조합에 대해 곱셈으로 종류의 수를 구함

```java
while (N-- > 0) {

  in.next(); // 옷 이름은 필요 없음

  String kind = in.next(); // 옷 종류

  if (hm.containsKey(kind)) {
    hm.put(kind, hm.get(kind) + 1);
  } else {
    hm.put(kind, 1);
  }
}
```


## :black_nib: **Review**  
이것도 쉽지 않아...

## 📡**Link**
https://www.acmicpc.net/problem/9375
