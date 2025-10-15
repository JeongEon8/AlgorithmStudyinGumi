# [백준 - G5] 25319. Twitch Plays VIIIbit Explorer (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N*M+C*L*(N+M))$

## :round_pushpin: **Logic**

1. 초기 데이터 수집 및 최대 반복 횟수(C) 계산
2. 경로 탐색 및 경로 생성
3. 종료 지점 이동 및 결과 출력

```java
1. 초기 데이터 수집 및 최대 반복 횟수(C) 계산
    HashMap<Character, ArrayList<Location>> charLocations = new HashMap<Character, ArrayList<Location>>();
	HashMap<Character, Integer> charFrequencies = new HashMap<Character, Integer>();
	String s = br.readLine();
	for (int i = 0; i < s.length(); i++) {
        // 문자 위치를 저장할 리스트 초기화
		charLocations.put(s.charAt(i), new ArrayList<Location>());
        // 문자열 문자 빈도수 수집
		if (charFrequencies.containsKey(s.charAt(i))) {
			charFrequencies.put(s.charAt(i), charFrequencies.get(s.charAt(i)) + 1);
		} else {
			charFrequencies.put(s.charAt(i), 1);
		}
	}

    // 던전 위치 수집
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (charLocations.containsKey(dungeon[i][j])) {
				charLocations.get(dungeon[i][j]).add(new Location(i, j));
			}
		}
	}

    // 최대 반복 횟수 결정
	for (int i = 0; i < s.length(); i++) {
		int count = charLocations.get(s.charAt(i)).size() / charFrequencies.get(s.charAt(i));
		if (C > count) {
			C = count;
		}
	}

2. 경로 탐색 및 경로 생성
    int currentRow = 0;
    int currentCol = 0;
    for (int i = 0; i < C; i++) {
        for (int j = 0; j < s.length(); j++) {
            Location nextLocation = charLocations.get(s.charAt(j)).get(0);
            int nextRow = nextLocation.row - currentRow;
            int nextCol = nextLocation.col - currentCol;

            appendPath(sb, nextRow, "D", "U");
            appendPath(sb, nextCol, "R", "L");

            sb.append("P");
            currentRow = nextLocation.row;
            currentCol = nextLocation.col;
            charLocations.get(s.charAt(j)).remove(0); // 사용한 위치는 제거
        }
    }

3. 종료 지점 이동 및 결과 출력
    int goalRow = N - 1 - currentRow;
    int goalCol = M - 1 - currentCol;
    appendPath(sb, goalRow, "D", "U");
    appendPath(sb, goalCol, "R", "L");

    System.out.println(C + " " + sb.length() + "\n" + sb.toString());

```

## :black_nib: **Review**

처음 제출에서는 목표 문자열 s를 만들 수 있는 최대 횟수 C를 잘못 계산하여 런타임 에러(IndexOutOfBounds)가 발생해서 C 값 다시 계산해서 런타임 에러를 해결했지만 다음 제출에서 시간초과가 발생했다. 로직에서 그렇게 시간 초과가 날 부분이 없어 보였지만 처음 로직에서 StringBuilder 대신 String을 사용해서 L의 길이가 길어지면 문자열을 붙이는 과정에서 시간초과가 발생할꺼 같았다. 그래서
String 대신 StringBuilder를 사용해서 시간초과를 해결했다.
문제를 풀다보면 String 대신 StringBuilder를 써야 시간 초과가 안나는 경우가 있는데 이걸 잘 파악 해야겠다.

## 📡**Link**

https://www.acmicpc.net/problem/25319
