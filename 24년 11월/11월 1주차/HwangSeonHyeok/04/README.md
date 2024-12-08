# [백준 - S4] 30647. 점수 관리

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 문자열
- 정렬
- 파싱

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

입력받은 정보를 파싱해서 이름, 점수, 점수 숨김여부를 Ranker객체에 넣는다.

```java
	static class Ranker implements Comparable<Ranker> {
		String name;
		int score, isHidden;

		public Ranker(String name, int score, int isHidden) {
			super();
			this.name = name;
			this.score = score;
			this.isHidden = isHidden;
		}

		@Override
		public int compareTo(Ranker o) {
			if (this.score == o.score) {
				return this.name.compareTo(o.name);
			}
			return o.score - this.score;
		}
	}
	Ranker[] ranking = new Ranker[n];
	for (int i = 0; i < n; i++) {
		String[] split = in.readLine().split("\"");
		String name = split[3];
		String scoreStr = "";
		for (int j = 1; j < split[6].length(); j++) {
			if (split[6].charAt(j) != ',') {
				scoreStr += split[6].charAt(j);
			}
		}
		int score = Integer.parseInt(scoreStr);
		int isHidden = split[8].charAt(1) - '0';
		ranking[i] = new Ranker(name, score, isHidden);
	}

```

파싱한 정보를 점수 내림차순, 이름 오름차순으로 정렬하고 동점자는 같은등수 숨겨진 사람은 등수엔 포함하되 출력하지 않게 한다.

```java
	Arrays.sort(ranking);
	int currentRanking = 1;
	if (ranking[0].isHidden == 0)
		sb.append("1 " + ranking[0].name + " " + ranking[0].score + "\n");
	for (int i = 1; i < n; i++) {
		if (ranking[i].score < ranking[i - 1].score) {
			currentRanking = i + 1;
		}
		if (ranking[i].isHidden == 0) {
			sb.append(currentRanking + " " + ranking[i].name + " " + ranking[i].score + "\n");
		}
	}
```

## :black_nib: **Review**

파싱을 더 잘할 수 있을거같은데..

## 📡**Link**

https://www.acmicpc.net/problem/30647
