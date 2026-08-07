# [PGS - Lv2] 02\_문자열 압축

## ⏰**time**

60분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 입력받은 단위 `cnt`($1$부터 $N/2$까지) 크기만큼 문자열을 연속해서 잘라 리스트에 저장
2. 첫 번째 조각을 기준(`prev`)으로 잡고, 다음 조각들과 비교하며 순회
   - 이전 조각과 같으면, `횟수 + 1`
   - 이전 조각과 다르면, 지금까지의 횟수와 기준 조각을 결과 문자열에 추가하고, 현재 조각을 기준으로 변경하고 횟수 초기화
3. 반복문 종료 후 처리되지 않고 남아있는 마지막 조각과 카운트를 결과 문자열 뒤에 추가

```java
static int comp(int cnt, String s) {
    List<String> chunks = new ArrayList<>();

    // 자르기
    for(int i = 0; i < s.length(); i += cnt) {
        int end = Math.min(i + cnt, s.length());
        String chunk = s.substring(i, end);
        chunks.add(chunk);
    }

    // 문자 압축
    StringBuilder sb = new StringBuilder();
    String prev = chunks.get(0);
    int count = 1;

    for(int i = 1; i < chunks.size(); i++) {
        String curr = chunks.get(i);

        if (prev.equals(curr)) {
            count++;
        } else {
            if (count > 1) sb.append(count);
            sb.append(prev);

            prev = curr;
            count = 1;
        }
    }

    if (count > 1) sb.append(count);
    sb.append(prev);

    return sb.length();
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/60057>
