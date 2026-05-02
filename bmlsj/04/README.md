# [PGS - LV2] 04_할인 행사

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 할인 배열에서 시작 인덱스를 기준으로 연속된 10일 구간을 슬라이딩 윈도우로 순회한다.
2. 각 구간마다 HashMap을 이용해 10일 동안의 할인 품목 개수를 카운트한다.
3. want 배열을 기준으로 각 품목이 원하는 수량과 정확히 일치하는지 확인한다.
4. 하나라도 수량이 다르면 실패, 모두 일치하면 해당 시작일을 가능한 날짜로 카운트한다.

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

원래는 10일간의 구매한 각 할인 품목의 수가 `number[k]` 이하면 정답이라고 생각했는데, 같지 않을 때로 변경해야한다

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/131127>
