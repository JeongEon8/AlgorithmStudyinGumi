# [백준 - S1] 1105. 팔 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(|L|)$

## :round_pushpin: **Logic**

L과 R이 주어질때, L과 같거나 크고 R보다 작거나 같은 자연수중 8이 가장 적게 들어가는 수를 구하는 문제였다.
두 수 L과 R의 자릿수가 다르면, 그 사이에는 8을 포함하지 않는 수가 존재할 수 있으므로 정답은 0이다.
자릿수가 같은 경우, 가장 앞자리부터 차례대로 비교한다. 각 자리에서 L과 R의 숫자가 같다면 해당 자리는 범위 내의 모든 수에서 고정된다. 이때 그 숫자가 8이라면, 반드시 포함되는 8이므로 개수를 증가시킨다.
처음으로 서로 다른 숫자가 나타나는 순간, 이후 자릿수는 자유롭게 변할 수 있으므로 탐색을 종료한다.
이렇게 강제로 포함될 수밖에 없는 8의 개수를 구한다.

```java
		if (L.length() != R.length()) {
			System.out.println(min);
			return;
		} else {
			for (int i = 0; i < L.length(); i++) {
				if (L.charAt(i) == R.charAt(i)) {
					if (L.charAt(i) == '8') {
						min++;
					}
				} else {
					break;
				}
			}

			System.out.println(min);
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1105
