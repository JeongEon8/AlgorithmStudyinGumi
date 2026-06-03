# [PGS - Lv2] 01_모음 사전

## ⏰**time**

36분

## :pushpin: **Algorithm**

* DFS
* 완전 탐색
* 백트래킹
* 문자열 생성

## ⏲️**Time Complexity**

$O(5^5)$
사용할 수 있는 문자는 `A`, `E`, `I`, `O`, `U` 총 5개이고, 단어의 최대 길이는 5이다.
길이 1부터 5까지 가능한 모든 단어를 DFS로 생성하므로 시간 복잡도는 상수에 가까운 $O(5^5)$로 볼 수 있다.

전체 생성되는 단어 수는 다음과 같다.

```text
5 + 5^2 + 5^3 + 5^4 + 5^5 = 3905
```

따라서 문제 제한에서는 충분히 빠르게 처리 가능하다.

## :round_pushpin: **Logic**

1. 사용할 수 있는 모음들을 사전 순서대로 배열에 저장한다.

```java
static String[] alphabets = { "A", "E", "I", "O", "U" };
```

2. DFS로 생성한 모든 단어를 저장할 리스트를 만든다.

```java
static List<String> a = new ArrayList<>();
```

3. 빈 문자열 `""`에서 시작해 DFS를 수행한다.

```java
dfs("");
```

4. 현재 문자열의 길이가 5가 되면 더 이상 문자를 추가할 수 없으므로 재귀를 종료한다.

```java
if (current.length() == 5) 
    return;
```

5. 현재 문자열 뒤에 `A`, `E`, `I`, `O`, `U`를 차례대로 붙인다.

   이 순서대로 탐색하면 리스트에 단어들이 사전 순서대로 저장된다.

```java
for (String alphabet : alphabets) {
    String next = current + alphabet;
    a.add(next);
    dfs(next);
}
```

6. 예를 들어 처음 탐색은 다음과 같은 순서로 진행된다.

```text
A
AA
AAA
AAAA
AAAAA
AAAAE
AAAAI
AAAAO
AAAAU
AAAE
...
```

7. 모든 단어를 생성한 뒤, 찾고자 하는 `word`의 인덱스를 구한다.

   리스트의 인덱스는 `0`부터 시작하지만 문제의 사전 순서는 `1`부터 시작하므로 `1`을 더해서 반환한다.

```java
return a.indexOf(word) + 1;
```

## :black_nib: **Review**

* 가능한 단어의 개수가 최대 3905개뿐이라 모든 단어를 DFS로 생성해도 충분히 해결 가능했다.
* `A`, `E`, `I`, `O`, `U` 순서대로 DFS를 수행하면 자연스럽게 사전 순서대로 단어가 저장된다는 점이 핵심이었다.
* 생성한 단어를 리스트에 저장한 뒤 `indexOf(word) + 1`로 답을 구할 수 있어 구현이 직관적이었다.
* 다만 `a`가 `static` 리스트이므로, 같은 `Solution` 객체에서 `solution()`이 여러 번 호출되는 환경이라면 이전 결과가 남을 수 있다. 코딩테스트에서는 보통 한 번만 호출되지만, 더 안전하게 하려면 `solution()` 시작 시 `a.clear()`를 호출하거나 리스트를 지역 변수로 관리하는 방식이 좋다.

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/84512](https://school.programmers.co.kr/learn/courses/30/lessons/84512)
