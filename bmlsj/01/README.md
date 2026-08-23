# [PGS - Lv2] 01\_할인행사

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(2^m)$

## :round_pushpin: **Logic**

1. 연속된 10일간의 할인 품목 수량을 카운팅하기 위해 슬라이딩 구간별로 HashMap을 생성
2. 시작일 i부터 `i + 10`까지의 할인 품목들을 tmp 맵에 수집
3. 정현이가 원하는 제품 목록(want)을 순회하며, 각 제품의 필요 수량(number)과 10일간 할인 수량이 일치하는지 검사
4. 모든 품목의 수량이 일치하면 가능한 날짜 카운트를 1 증가

```java
for(int i = 0; i <= discount.length - 10; i++) {
    HashMap<String, Integer> tmp = new HashMap<>();

    for(int j = i; j < i + 10; j++) {
        tmp.put(discount[j], tmp.getOrDefault(discount[j], 0) + 1);
    }

    boolean check = true;
    for (int k = 0; k < want.length; k++) {
        if (tmp.getOrDefault(want[k], 0) != number[k]) {
            check = false;
            break;
        }
    }
    if (check) answer++;
}
```

## :black_nib: **Review**

-

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/131127>
