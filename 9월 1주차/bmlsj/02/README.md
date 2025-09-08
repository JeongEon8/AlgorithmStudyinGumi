
# [백준- G5] 1759. 암호 만들기

## ⏰  **time**
30분

## :pushpin: **Algorithm**
백트래킹

## ⏲️**Time Complexity**
$O(\binom{C}{L})$

## :round_pushpin: **Logic**

1. C개의 문자를 입력받아 정렬한다.

2. 백트래킹을 통해 길이가 L인 모든 문자열을 생성한다.

3. 문자열 길이가 `L`이 되면 `check`로 조건을 확인한다.
   - 모음은 최소 1개 이상
   - 자음은 최소 2개 이상



```java
static void combi(int L, int C, char[] charList, String sen, int start) {

		if (sen.length() == L) {
			if (check(sen, L)) {
				System.out.println(sen);
			}
			// System.out.println(sen);
			return;
		}

		for (int i = start; i < C; i++) {
			combi(L, C, charList, sen + charList[i], i + 1);

		}
}
```


## :black_nib: **Review**

문자를 정렬하면, 따로 정렬 검사를 하지 않아도 사전순으로 출력 가능하다.


## 📡**Link**
- https://www.acmicpc.net/problem/1759

