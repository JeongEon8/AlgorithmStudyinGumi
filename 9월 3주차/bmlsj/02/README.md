# [PGS - LV3] 02

## ⏰**time**

30분

## :pushpin: **Algorithm**

해시

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. map에 각 판매원 당 인덱스 값을 매핑한다
2. seller를 순회하며 이익금(`amount[i] * 100`)을 계산
3. while을 통해 추천인을 따라 점차 올라가며, tip인 10%를 넘겨주고 나머지 90%는 자신의 이익으로 둔다
4. 추천인이 `-`이 되거나 분배할 금액이 0이되면 종료

```java
for(int i = 0; i < seller.length; i++) {

    String curr = seller[i];
    int money = amount[i] * 100;

    while(!curr.equals("-") && money > 0) {
        int curIdx = map.get(curr);
        int tip = money / 10;

        answer[curIdx] += money - tip;
        curr = referral[curIdx];
        money = tip;
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/77486>
