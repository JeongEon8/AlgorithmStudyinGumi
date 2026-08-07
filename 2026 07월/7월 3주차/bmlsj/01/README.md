# [PGS - Lv2] 01\_[3차] n진수 게임

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. **전체 확보할 글자 수 계산**: 내가 구해야 하는 횟수($t$)와 참가 인원($m$)을 곱해 최소 필요한 총 글자 수(`t * m`)를 구함.
2. **n진수 문자열 분할 및 리스트 생성**: 0부터 숫자를 1씩 키워가며 $n$진수로 변환하고 대문자 처리한 뒤, 각 자리 글자를 순서대로 `List`에 하나씩 집어넣어 전체 문자열 생성
3. **내 순서의 글자 추출**: 0번 인덱스 기준으로 내 차례인 `p - 1`부터 시작해 참가 인원($m$)만큼 인덱스를 건너뛰며 정답을 추출하고, 원하는 개수($t$)를 채우면 종료

```java
int end = t * m;
List<String> list = new ArrayList<>();
for(int i = 0; i <= end; i++) {
    String change = Integer.toString(i, n).toUpperCase();
    for(char c: change.toCharArray()) {
        list.add(c + "");
    }

}

for(int i = p - 1; i < list.size(); i += m) {
    answer += list.get(i);
    if (answer.length() == t) break;
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/17687>
