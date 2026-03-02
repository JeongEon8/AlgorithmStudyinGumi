# [백준 - G5] 26266. 비즈네르 암호 해독 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 문자열
- 브루트포스 알고리즘
- 정수론

## ⏲️**Time Complexity**

$O(N * d(N))$

## :round_pushpin: **Logic**

평문 + 키 = 암호문 이므로, 키 = 암호문 - 평문으로 구할 수 있다.
s1을 평문, s2를 암호문이라고 할 때, 각 위치에서 평문 문자를 암호문 문자로 만들기 위해 알파벳을 몇 칸 이동해야 하는지 계산한다. 알파벳은 A~Z로 순환하므로, 계산 결과가 음수가 나오면 26을 더해 보정한다.
이렇게 각 위치마다 필요한 이동 값을 문자로 변환하여 이어 붙이면 전체 key 문자열이 된다.
이후 이 key 문자열이 어떤 최소 길이의 문자열이 반복된 형태인지 확인하고, 가장 짧은 반복 패턴을 정답으로 출력한다.

```java
		for (int i = 0; i < s1.length(); i++) {
			if (s2.charAt(i) > s1.charAt(i)) {
				sb.append((char) (s2.charAt(i) - s1.charAt(i) + 'A' - 1));
			} else {
				sb.append((char) (s2.charAt(i) - s1.charAt(i) + 'A' - 1 + 26));
			}
		}

		String key = sb.toString();

		for (int i = 1; i <= key.length() / 2; i++) {
			if (key.length() % i == 0) {
				String sub = key.substring(0, i);
				sb = new StringBuilder();

				for (int j = 0; j < key.length() / i; j++) {
					sb.append(sub);
				}

				if (sb.toString().equals(key)) {
					System.out.println(sub);
					return;
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/26266