# [PGS - lv1] 2025 카카오 하반기 1차 - 01_중요한 단어를 스포 방지

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. message를 공백 기준으로 나누어 단어 리스트 생성
2. 각 단어의 `(시작 인덱스, 끝 인덱스)`범위를 함께 저장

3. 모든 spoiler 범위를 순회하면서
   → 각 단어가 spoiler와 한 글자라도 겹치면 set에 추가

4. set에 있는 단어들을 하나씩 검사
   1. 해당 단어의 전체 등장 횟수(total) 계산
   2. 그 중 spoiler 범위에 포함된 횟수(inSpoiler) 계산

5. `total == inSpoiler` 인 경우
   → 해당 단어는 모든 등장 위치가 스포일러에 포함된 것
   → answer++

```java
for(String s: set) {
    int total = 0;
    int inSpoiler = 0;

    for(int i = 0; i < words.size(); i++) {
        if (words.get(i).equals(s)) {
            total++;

            int ws = ranges.get(i)[0];
            int we = ranges.get(i)[1];

            // 스포 방지 단어인가
            for (int[] spoiler : spoiler_ranges) {
                int start = spoiler[0];
                int end = spoiler[1];

                if (!(we < start || ws > end)) {
                    inSpoiler++;
                    break;
                }
            }

        }
    }

    if (total == inSpoiler) {
        answer++;
    }
}
```

## :black_nib: **Review**

카카오 이름만 보고 풀었는데 lv1 이라는 충격 소식..
아까우니까 올리기

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/468370>
