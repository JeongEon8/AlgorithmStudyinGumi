# [백준 - S2] 22941. RPG 마스터 오명진 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

용사가 마왕한테 공격당하는 횟수를 계산하고 마왕이 용사에게 죽는데 필요한 턴 수는 용사가 공격해서 마왕의 HP가 P이하가 될 때 까지 필요한 턴을 구하고 마왕의 피가 0 이하가 아니라면 회복을 하고 아니면 회복을 안하게 한다. 그런다음 회복된 HP가 0이하가 될 때 까지 필요한 턴을 구해서 demonDethCount에 더하고 둘을 비교하도록 한다.

```java
		long playerDethCount = playerHp % demonAtk == 0 ? playerHp / demonAtk : playerHp / demonAtk + 1;
		long demonDethCount = (demonHp - P) % playerAtk == 0 ? (demonHp - P) / playerAtk
				: (demonHp - P) / playerAtk + 1;

		demonHp -= (demonDethCount) * playerAtk;
		demonHp = demonHp <= 0 ? 0 : demonHp + S;
		demonDethCount += demonHp % playerAtk == 0 ? demonHp / playerAtk : demonHp / playerAtk + 1;

		if (playerDethCount >= demonDethCount) {
			System.out.println("Victory!");
		} else {
			System.out.println("gg");
		}
```

## :black_nib: **Review**

그냥 수학 문제였다.

## 📡**Link**

https://www.acmicpc.net/problem/22941
