# [PGS - Lv2] 02\_연속 부분 수열 합의 개수

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 길이가 1부터 `elements.length`까지 연속 부분 수열의 합을 구한다.
   여기서 `elements.length`를 넘어설 경우 다시 인덱스 0부터 더해야하기 때문에
   `elements[j % elements.length]`를 더해준다.
2. 나올 수 있는 모든 경우를 한 set에 더해서 중복된 부분을 제거한다.
   - 정렬된 모습을 보고 싶어서 TreeSet 사용해줌

```java
static void calc(int size, int[] elements) {

    for(int i = 0; i < elements.length; i++) {
        int num = elements[i];
        for(int j = i + 1; j < i + size; j++) {
            num += elements[j % elements.length];
        }
        set.add(num);
    }
}
```

## :black_nib: **Review**

처음엔 정렬을 하고 진행했는데, 원형 수열이라 정렬을 하지 않고 `elements` 크기를 넘어서도 다시 처음부터 더할 수 있게 해야함

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/131701>
