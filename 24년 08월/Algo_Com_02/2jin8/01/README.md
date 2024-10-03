# [SWEA - 모의 SW 역량테스트] 5658. 보물상자 비밀번호
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
구현

## :round_pushpin: **Logic**
- 계속 반복되므로 `N / 4`번까지만 회전하면 됨
- 한 번의 회전 당 생성 가능한 수는 총 4개 ⇒ 4번만 반복하면 됨
- `substring`을 사용해서 문자열을 얻고 `HashSet`에 저장하여 중복을 없앰
  - 그냥 `substring`을 하면 인덱스 초과가 발생하므로, 편의상 문자열을 두 번 붙임
```java
String box = br.readLine();
box += box;
int repeat = N / 4;
for (int i = 0; i < repeat; i++) {
    for (int j = 0; j < 4; j++) {
        int start = i + repeat * j;
        password.add(box.substring(start, start + repeat));
    }
}
List<String> pwList = password.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
String pw = pwList.get(K - 1);
```

## :black_nib: **Review**
- `Integer.parseInt("1F7", 16)`을 이용해서 10진수를 16진수로 변환할 수 있다..!
- 무작정 코딩 시작하지 말고 풀이 로직을 다 정한 뒤에 문제를 풀도록 하자.

## 📡**Link**
- [SWEA 5658_보물상자 비밀번호](https://swexpertacademy.com/main/code/problem/problemDetail.do)
