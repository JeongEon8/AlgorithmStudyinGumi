# [백준 - G4] 25597. 푸앙이와 러닝머신 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘
- 많은 조건 분기

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

가능한 경우의 수를 우선순위에 따라 단계적으로 검사하는 방식이다.
8 버튼만 사용해서 정확히 만들 수 있는지 확인
아니면 4 버튼만 사용해서 정확히 만들 수 있는지 확인
아니면 1 버튼만 사용해서 정확히 만들 수 있는지 확인
아니면 8 버튼 + 4 버튼 조합으로 만들 수 있는지 확인
아니면 8 버튼 + 1 버튼 조합으로 만들 수 있는지 확인
아니면 8 버튼 + 4 버튼 + 1 버튼 조합으로 만들 수 있는지 확인
위 모든 경우가 불가능하면 -1 을 출력한다.

```java
		if (targetDistance % 8 == 0 && targetDistance / 8 <= targetTime) {
			eightDiv = targetDistance / 8;
		} else if (targetDistance % 4 == 0 && targetDistance / 4 <= targetTime) {
			fourDiv = targetDistance / 4;
		} else if (targetDistance / 1 <= targetTime) {
			oneDiv = targetDistance / 1;
		} else if ((targetDistance % 8) % 4 == 0 && (targetDistance / 8) + ((targetDistance % 8) / 4) <= targetTime) {
			eightDiv = targetDistance / 8;
			targetDistance %= 8;
			fourDiv = targetDistance / 4;
		} else if ((targetDistance % 8) % 1 == 0 && (targetDistance / 8) + (targetDistance % 8) <= targetTime) {
			eightDiv = targetDistance / 8;
			targetDistance %= 8;
			oneDiv = targetDistance;
		} else if (((targetDistance % 8) % 4) % 1 == 0
				&& (targetDistance / 8) + ((targetDistance % 8) / 4) + ((targetDistance % 8) % 4) <= targetTime) {
			eightDiv = targetDistance / 8;
			targetDistance %= 8;
			fourDiv = targetDistance / 4;
			targetDistance %= 4;
			oneDiv = targetDistance;
		} else {
			System.out.println(-1);
			return;
		}

		int[] arr = { oneDiv, fourDiv, eightDiv };
		List<ButtonPressRecord> records = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (arr[i] != 0) {
				count++;
				records.add(new ButtonPressRecord(remainTime - arr[i], D[i]));
				remainTime -= arr[i];
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25597
