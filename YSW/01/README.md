# [백준 - S5] 29812. 아니 이게 왜 안 돼 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

H, Y, U 가 아닌 문자가 나왔을때 문자열의 길이를 기록하고 문자열 길이가 1이상이면 Drag + Delete 또는 Delete 여러번, 길이가 1일때는 Delete 한번으로 해서 에너지 계산하고, HYU를 만들수 있는 개수는 HashMap에 H, Y, U 담아서 제일 개수가 작은 걸로 판단했다.

```java
        for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'H' || S.charAt(i) == 'Y' || S.charAt(i) == 'U') {
				counts.put(S.charAt(i), counts.get(S.charAt(i)) + 1);
				continue;
			} else {
				int index = 1;
				while (i + index < S.length()) {
					if (S.charAt(i + index) == 'H' || S.charAt(i + index) == 'Y' || S.charAt(i + index) == 'U') {
						break;
					}
					index++;
				}

				sb.delete(i, i + index);
				S = sb.toString();
				if (index > 1) {
					if(D + M > D * index) {
						energy += D * index;
					}else {
						energy += D + M;
					}
				} else {
					energy += D;
				}
				i--;
			}
		}

		for (int count : counts.values()) {
			if (countHYU > count) {
				countHYU = count;
			}
		}
```

## :black_nib: **Review**

3번 정도 실패 했는데 Delete키 연속으로 눌러서 지울 때가 Drag해서 Delete키로 지울 때 보다 효과적일꺼라는 생각을 못했었다.

## 📡**Link**

https://www.acmicpc.net/problem/29812
