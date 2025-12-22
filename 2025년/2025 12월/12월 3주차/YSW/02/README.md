# [백준 - S4] 22993. 서든어택 3 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

본인을 제외한 다른 플레이어들의 공격력을 오름차순으로 정렬한 뒤, 공격력이 낮은 플레이어부터 차례대로 내 공격력과 비교한다.
만약 현재 내 공격력이 상대방보다 크다면 해당 플레이어를 이길 수 있으므로 상대방의 공격력을 내 공격력에 더해 누적한다.
이 과정 중 내 공격력보다 같거나 높은 공격력을 가진 플레이어가 등장하면 더 이상 진행할 수 없으므로 "No"를 출력하고 종료한다.
모든 플레이어를 순서대로 이길 수 있다면 "Yes"를 출력한다.

```java
		for (int i = 1; i < N; i++) {
			playerAtk[i] = Integer.parseInt(inputs[i]);
		}

		Arrays.sort(playerAtk);

		for (int i = 1; i < N; i++) {
			if (myAtk > playerAtk[i]) {
				myAtk += playerAtk[i];
			} else {
				System.out.println("No");
				return;
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/22993
